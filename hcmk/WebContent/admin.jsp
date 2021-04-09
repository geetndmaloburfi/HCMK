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



		<div class="col-9 bg-light">
		<ul class="text-dark mt-3 ml-3">
		<li><i class="fa fa-fw fa-user fa-10x mt-3 ml-3"></i></li>
		<li class="mt-3 ml-3">WELCOME TO ADMIN PENAL</li>
		<li class="mt-3 ml-3">You can perform admin activity here only </li>
		<li class="mt-3 ml-3"><a href="<%=request.getContextPath()%>/Logout">Log Out</a></li>
		</ul>
		
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />