<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username=null,sessionID=null;
boolean currentLoggedInAdmin=false;
if(request.getSession().getAttribute("username") ==null )
{
	%>
	<jsp:include page="/include/header.jsp"/>
	<%
}
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



<div class="container-fluid">
	<div class="row">
		<div class=" bg-black text-white col-12 col-md-3 col-xl-2 bd-sidebar"
			style="background-color: black;">
			<div class=" mt-3 mb-3">
				<h2 class="text-muted">HCMK ADMIN PENAL</h2>
				<%int getlink=0; %>
				<ul class="nav nav-tabs flex-column">
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=1;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=1">VIEW ALL PRODUCTS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=2;%>" href="#">ADD PRODUCTS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=4;%>" href="#">ALL CATEGORY</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=5;%>" href="#">ADD CATEGORY</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=6;%>" href="#">VIEW USERS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=7;%>" href="#">VIEW ORDERS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=8;%>" href="#">ADD ADMIN</a></li>
					
				</ul>
			</div>
		</div>
		<div class="col-9 bg-light">
			<%if(getlink==1){%>
			<jsp:include page="/adminpages/showproducts.jsp"/>
			<%} %>
			
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />