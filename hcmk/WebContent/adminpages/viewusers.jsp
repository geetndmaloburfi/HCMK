<%@page import="hcmk.com.hibernate.DAO.UsersDAO"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username = null, sessionID = null;
boolean currentLoggedInAdmin = false;
if (request.getSession().getAttribute("username") == null) {
%>
<jsp:include page="/index.jsp" />
<%
return ;} else {
if (request.getSession().getAttribute("Admin").equals("yes")) {
	username = request.getSession().getAttribute("username").toString();
	sessionID = request.getSession().getId();
%>
<jsp:include page="/include/adminheader.jsp" />
<%
}
}
%>



<div class="col-9 bg-light">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">User Name</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Phone</th>
			</tr>
		</thead>
		<tbody>
			<%!List<Users> users = UsersDAO.getAllUser();%>
			<c:forEach items="<%=users%>" var="user">
				<tr>
					<th scope="row">${user.userName}</th>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.emailAddress }</td>
					<td>${user.contactDetail }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
</div>


<jsp:include page="/include/footer.jsp" />
