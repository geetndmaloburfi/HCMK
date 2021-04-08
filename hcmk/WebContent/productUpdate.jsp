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
<jsp:include page="/include/header.jsp" />
<%
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
	<div class="card-header"><h1 class="text-center">Enter your values to update Product with productId : ${product.productId }</h1>
	<h2 class="text-center">Below are given existing values</h2></div>
	<form class="m-3"action="<%=request.getContextPath()%>/UpdateProduct" method="post">
		<div class="form-row">
		
			<div class="form-group col-md-6">
				<p >Product Name</p> <input type="text"
					class="form-control" name="pname"  value="${product.productName }">
			</div>
			<div class="form-group col-md-6">
				<p >Product Title</p> <input type="text"
					class="form-control" name="ptitle" value="${product.title }">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p >Product Metal</p> <input type="text"
					class="form-control" name="pmetal" value="${product.metal }">
			</div>
			<div class="form-group col-md-6">
				<p >Product Price</p> <input type="text"
					class="form-control" name="pprice" value="${product.price }">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p >Product Purity</p> <input type="number"
					class="form-control" name="ppurity" value="${product.purity }">
			</div>
			<div class="form-group col-md-6">
				<p >Product Quantity</p> <input type="number"
					class="form-control" name="pquantity" value="${product.quantity }">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p >Product Making Charges</p> <input type="text"
					class="form-control" name="pmc" value="${product.makingCharge }">
			</div>
		</div>
		
		<div class="form-group">
			<p>Product Summary</p> 
			<input class="form-control" name="psummary" value="${product.summary}" rows="3"></input>
		</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" name="pbestseller" type="checkbox" value="${product.bestseller }">
					<p class="form-check-label" > BestSeller</p>
				</div>
			</div>
			<input type="hidden" name="idnum" value="${product.productId }">
		<button  type="submit" class="btn btn-primary ">Update</button>
		<button type="reset" class="btn btn-primary ">Reset</button>
	</form>
	</div>

</div>
</div>
</div>


<jsp:include page="/include/footer.jsp" />
