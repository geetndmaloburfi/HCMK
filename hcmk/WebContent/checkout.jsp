<%@page import="hcmk.com.hibernate.entity.Users"%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username = null, sessionID = null;
String currentLoggedInUser = null;
if (request.getSession().getAttribute("username") == null) {
	session.setAttribute("message", "Your are not logged in please login first to Checkout");
	response.sendRedirect("Login");
} else {
	username = request.getSession().getAttribute("username").toString();

	sessionID = request.getSession().getId();
%>
<jsp:include page="/include/userheader.jsp" />
<%
}
%>
<div class="container">
	<div class="row mt-5">
		<div class="col-md-6">
			<div class="card">
				<h4 class="m-3">Your cart products</h4>
			</div>
			<div class="card">
				<div class="cart-body"></div>
			</div>
		</div>
		<div class="col-md-6">
		<% %>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />