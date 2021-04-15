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
					<li class="nav-item "><a class="nav-link text-light"
						onclick="<%getlink = 1;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=1">View
							Orders</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						onclick="<%getlink = 2;%>"
						href="<%=request.getContextPath()%>/Dashboard?getlink=2">View
							Cart</a></li>
					<li class="nav-item active"><a class="nav-link text-light"
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
			<%
			List<Address> myaddress=null;
			myaddress= AddressDAO.getAddressList(username);
			%>
			<%if(myaddress.size()==0){ %>
			<h4 class="text-secondary text-center m-5">Please Update Your Address <i class="far fa-frown-open"></i></h4>
			<%} %>
			<%if( myaddress != null ){ %>
		<h4 class="text-secondary text-center m-5">Your Addresses</h4>
			<div class="table-responsive">
				<table class='table table-hover '>
					<thead class='thread-dark'>
						<tr>
							<th>Street Address</th>
							<th>City</th>
							<th>Country</th>
							<th>Pincode</th>
							<th>Pan</th>
							<th>Adhar Card No</th>
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="<%=myaddress%>" var="address">
						<tr>
							<td>${address.streetAddress }</td>
							<td>${address.city }</td>
							<td>${address.country }</td>
							<td>${address.pincode }</td>
							<td>${address.panNo }</td>
							<td>${address.adharNo }</td>
							<td><form action="<%=request.getContextPath()%>/DeleteAddress" method=post>
							<input type="hidden" name="address" value="${address.addressId }"> 
							<button type="submit" class="btn btn-promary">DELETE</button>
						</form></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%} %>
			
			 
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />