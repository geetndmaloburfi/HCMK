<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="java.util.List,java.lang.Integer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username = null, sessionID = null;
if (request.getSession().getAttribute("username") == null) {
%>
<jsp:include page="/include/header.jsp" />
<%
} else {
username = request.getSession().getAttribute("username").toString();
sessionID = request.getSession().getId();
%>
<jsp:include page="/include/userheader.jsp" />
<%
}
%>

<div class="container ">
	<div class="row">
		<div class="col m-3">
			<div class="img-magnifier-container">
				<img id="myimage" src="${product.photos}" width="600" height="600">
			</div>
		</div>
		
		<div class="col m-3">
		<div class="container-fluid">
			<div class="card my-5">
			<h1>${product.title}</h1>
			<h2>${product.price }</h2>
			<h3>${product.makingCharge}</h3>
			<p class="text-secondary">${product.summary }</p>
			<a href="<%=request.getContextPath()%>/Product?p=${product.productId}&admin=true" class="btn btn-primary">DELETE</a>
								
			</div>
		</div>
		</div>
	</div>
</div>



<jsp:include page="/include/footer.jsp" />