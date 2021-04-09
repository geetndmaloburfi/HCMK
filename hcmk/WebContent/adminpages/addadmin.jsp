<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
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
return; 
} else {
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
	<div class="card">
		<div class="card-header">
			<h1 class="text-center">Enter your values to Add Product</h1>
			<h2 class="text-center"></h2>
		</div>
		<form class="m-3" action="<%=request.getContextPath()%>/Admin"
			method="post" enctype="multipart/form-data">
			<div class="form-row">

				<div class="form-group col-md-6">
					<p>Admin User Name</p>
					<input type="text" class="form-control" name="aun"
						required>
				</div>
				<div class="form-group col-md-6">
					<p>First Name</p>
					<input type="text" class="form-control" name="afn"
						required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<p>Last Name</p>
					<input type="text" class="form-control" name="aln"
						required>
				</div>
				<div class="form-group col-md-6">
					<p>Contact</p>
					<input type="text" class="form-control" name="acd"
						required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<p>Password</p>
					<input type="password" class="form-control" name="apass"
						required>
				</div>
				</div>
			<button type="submit" class="btn btn-primary ">Add</button>
			<button type="reset" class="btn btn-primary ">Reset</button>
		</form>
	</div>

</div>
</div>
</div>
<jsp:include page="/include/footer.jsp" />
