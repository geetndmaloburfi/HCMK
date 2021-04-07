<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username=null,sessionID=null;
String currentLoggedInUser=null;
if(request.getSession().getAttribute("username") == null )
{
	%>
	<jsp:include page="/include/header.jsp"/>
	<%
}
else{
	username=request.getSession().getAttribute("username").toString();
	
	sessionID=request.getSession().getId();
	%>
	<jsp:include page="/include/userheader.jsp"/>
	<%
}
%>
<div class="one">
	<div class="container">
		<div class="row ">
			<div class="col-md-6 offset-md-3">
				<div class="card mt-3 mb-3">
				<div class="card-header">
					<p class="sign" align="center">ADMIN LOGIN HERE</p>
				</div>
				<form action="<%=request.getContextPath()%>/ValidateAdmin"
				method="post" class="mb-3 mt-3">
						<div class="form-group container mt-3 mb-3">
							<p class="ungiven">User name:</p> <input type="text"
								class="form-control"  name="userName" required placeholder="Enter Username" id="email">
						</div>
						<div class="form-group mt-3 mb-3 container">
							<p class="ungiven">password</p> <input type="password"
								class="form-control" name="password" placeholder="Enter password" id="pwd">
						</div>
						<div class="container text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />