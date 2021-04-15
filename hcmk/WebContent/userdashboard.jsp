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
			<div class="container">
				<div class="row">
					<div class="col m-5 border-info border">
						<p class="text-center mt-2">
							<a href="<%=request.getContextPath()%>/Dashboard?getlink=1">
								Orders <br>
							<br>
							<i class="fas fa-truck fa-10x" style="color: #508991;"></i>
							</a>
						</p>
					</div>
					<div class="col m-5 border-info border">
						<p class="text-center mt-2">
							<a href="<%=request.getContextPath()%>/Dashboard?getlink=2"> Cart <br>
							<br>
							<i class="fas fa-shopping-cart fa-10x" style="color: #508991;"></i></a>
						</p>
					</div>
					<div class="col m-5 border-info border">
						<p class="text-center mt-2">
							<a href="<%=request.getContextPath()%>/Dashboard?getlink=3">View Address <br>
							<br>
							<i class="fas fa-map-marker-alt fa-10x" style="color: #508991;"></i></a>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col m-5 border-info border ">
						<p class="text-center mt-2">
							<a href="<%=request.getContextPath()%>/Dashboard?getlink=4">Add New Address <br>
							<br>
							<i class="fas fa-user-edit fa-10x" style="color: #508991;"></i></a>
						</p>
					</div>
					<div class="col m-5 border-info border">
						<p class="text-center mt-2">
							<a href="<%=request.getContextPath()%>/Logout">LogOut <br>
							<br>
							<i class="fas fa-sign-out-alt fa-10x" style="color: #508991;"></i></a>
						</p>
					</div>
				</div>
				<div>
					<img src="images/razorlogo.png" width="1200">
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />