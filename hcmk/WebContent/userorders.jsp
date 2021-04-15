<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.DAO.OrderDetailDAO"%>
<%@page import="hcmk.com.hibernate.DAO.OrdersDAO"%>
<%@page import="hcmk.com.hibernate.DAO.UsersDAO"%>
<%@page import="hcmk.com.hibernate.DAO.AddressDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="hcmk.com.hibernate.entity.Orders"%>
<%@page import="hcmk.com.hibernate.entity.Address"%>
<%@page import="hcmk.com.hibernate.entity.OrderDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username = null, sessionID = null;
String currentLoggedInUser = null;
if (request.getSession().getAttribute("username") == null) {

	response.sendRedirect("index.jsp");

} else {
	username = request.getSession().getAttribute("username").toString();

	sessionID = request.getSession().getId();
%>
<jsp:include page="/include/userheader.jsp" />
<%
}
%>
<div class="container-fluid">
	<div class="row">
		<div class=" bg-black text-white col-12 col-md-3 col-xl-2 bd-sidebar"
			style="background-color: black;">
			<div class=" mt-3 mb-3">
				<h5 class="text-muted">User Dashboard</h5>
				<%
				int getlink = 0;
				%>
				<ul class="nav nav-tabs flex-column">
					<li class="nav-item active"><a class="nav-link text-light"
						onclick="<%getlink = 1;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=1">View
							Orders</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						onclick="<%getlink = 2;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=2">View
							Cart</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						onclick="<%getlink = 4;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=3">View
							Address</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						onclick="<%getlink = 4;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=4">Add
							New Address</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						onclick="<%getlink = 8;%>"
						href="<%=request.getContextPath()%>/Logout">Log Out</a></li>
				</ul>
			</div>
		</div>
		<div class="col-9 bg-light">
			<% int i=0;
			List<Orders> orders=null;
			 orders= OrdersDAO.getOrdersByUser(username);
			%>

			<c:forEach items="<%=orders%>" var="order">
				<div class="card sm rounded border m-5">
					<div class="card-header " style="background-color:#e2e3e3;">
						<h4 class="text-secondary mt-2" >Date: ${order.orderDate } Status: ${order.status }</h4>
							<span class="text-secondary mt-2 text-right">TransactionId : ${order.razorOrderId }</span>
					</div>
					<div class="card-body">
					<% long a = orders.get(i).getAddressId().getAddressId();
					Address address=AddressDAO.getAddressbyId(a);
					%>
					<div class="table-responsive">
					<table class='table table-hover '>
					<thead class='thread-dark'>
						<tr>
						<th>Product Photo</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Making Charges</th>
							<th>Quantity</th>
							<th>Total Price</th>
						</tr>
					</thead>
					<%List<OrderDetail> details=OrderDetailDAO.getOrderDetailListByOrderId(orders.get(i).getOrderId()); 
					List<Product> products=new ArrayList<Product>();
					for(OrderDetail o:details)
					{
						Product p=ProductDAO.getProductById((int)o.getProductId().getProductId());
						products.add(p);
					}
					%>
					<%
					int j = 0;
					for (; j < details.size() && j < products.size(); j++) {
					%>
					
					<tr>
					<td ><a href="<%=request.getContextPath()%>/Product?p=<%=products.get(j).getProductId()%>"><img class="border rounded" src="<%=products.get(j).getPhotos()%>" width=50></a></td>
						<td><%=products.get(j).getProductName()%></td>
						<td><%=products.get(j).getPrice()%></td>
						<td><%=products.get(j).getMakingCharge()%></td>
						<td><%=details.get(j).getQuantity()%></td>
						<td><%=details.get(j).getTotalPrice()%></td>
					</tr>
					
					<%}	%>
					</table>
					</div>
						<p class="text-secondary text-right"> Address : <%=address.getStreetAddress()+" ,"+address.getCity()+" ,"+address.getCountry()+" , ("+address.getPincode()+")"  %></p>
					</div>
				</div>
				<%i++; %>
			</c:forEach>
			<c:if test="${orders== null }">
			<h4 class="text-secondary text-center m-5">You Haven't Ordered Something Yet <i class="far fa-frown-open"></i></h4>
			</c:if>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />