<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.DAO.CartDetailDAO"%>
<%@page import="hcmk.com.hibernate.DAO.CartDAO"%>
<%@page import="hcmk.com.hibernate.DAO.UsersDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="hcmk.com.hibernate.entity.Cart"%>
<%@page import="hcmk.com.hibernate.entity.CartDetail"%>
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
					<li class="nav-item"><a class="nav-link text-light"
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
			<div class="card">
				<div class="card-header">
					<h1 class="text-center">Enter your values to Add Product</h1>
					<h2 class="text-center"></h2>
				</div>
				<form class="m-3" action="<%=request.getContextPath()%>/AddAddress"
					method="post">
					<div class="form-row">

						<div class="form-group col-md-6">
							<p>Street Address</p>
							<input type="text" class="form-control" name="street"
								value="" required>
						</div>
						<div class="form-group col-md-6">
							<p>City</p>
							<input type="text" class="form-control" name="city"
								required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<p>Country</p>
							<input type="text" class="form-control" name="country"
								required>
						</div>
						<div class="form-group col-md-6">
							<p>Pincode</p>
							<input type="text" class="form-control" name="pincode"
								required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<p>Pan Number</p>
							<input type="text" class="form-control" name="pno"
								required>
						</div>
						<div class="form-group col-md-6">
							<p>Adhar Card Number</p>
							<input type="text" class="form-control" name="adhar"
								required>
						</div>
					</div>

					
					<input type="hidden" name="user" value="${username }">
					<button type="submit" class="btn btn-primary ">Add</button>
					<button type="reset" class="btn btn-primary ">Reset</button>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />