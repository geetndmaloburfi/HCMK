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
String username=null,sessionID=null;
boolean currentLoggedInAdmin=false;
if(request.getSession().getAttribute("username") ==null )
{
	%>
	<jsp:include page="/index.jsp" />
<%
return ;}
else{
	if(request.getSession().getAttribute("Admin").equals("yes"))
	{
	username=request.getSession().getAttribute("username").toString();
	sessionID=request.getSession().getId();
	%>
	<jsp:include page="/include/adminheader.jsp"/>
	<%
	}
}
%>


<div class="col-9 bg-light">
		<% int i=0;
			List<Orders> orders=null;
			 orders= OrdersDAO.getAllOrders();
			%>

			<c:forEach items="<%=orders%>" var="order">
				<div class="card sm rounded border m-5">
					<div class="card-header " style="background-color:#e2e3e3;">
						<h4 class="text-secondary mt-2" >Date: ${order.orderDate } Status: ${order.status }  <span class="text-info"> User : ${order.userName.userName }</span></h4>
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
			
		</div>
	</div>
</div>


<jsp:include page="/include/footer.jsp" />







