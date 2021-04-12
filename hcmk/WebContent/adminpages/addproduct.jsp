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
	<div class="card">
		<div class="card-header">
			<h1 class="text-center">Enter your values to Add Product</h1>
			<h2 class="text-center"></h2>
		</div>
		<form class="m-3" action="<%=request.getContextPath()%>/AddProduct"
			method="post" enctype="multipart/form-data">
			<div class="form-row">

				<div class="form-group col-md-6">
					<p>Product Name</p>
					<input type="text" class="form-control" name="pname"
						value="${product.productName }">
				</div>
				<div class="form-group col-md-6">
					<p>Product Title</p>
					<input type="text" class="form-control" name="ptitle"
						value="${product.title }">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<p>Product Metal</p>
					<input type="text" class="form-control" name="pmetal"
						value="${product.metal }">
				</div>
				<div class="form-group col-md-6">
					<p>Product Price</p>
					<input type="text" class="form-control" name="pprice"
						value="${product.price }">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<p>Product Purity</p>
					<input type="number" class="form-control" name="ppurity"
						value="${product.purity }">
				</div>
				<div class="form-group col-md-6">
					<p>Product Quantity</p>
					<input type="number" class="form-control" name="pquantity"
						value="${product.quantity }">
				</div>
			</div>
			
				<div class="form-group">
					<p>Product Making Charges</p>
					<input type="text" class="form-control" name="pmc"
						value="${product.makingCharge }">
				</div>
				
			
			<div class="input-group m-3">
			<div class="container">
			<p>ProductPhoto</p>
				<div class="custom-file">
					<input type="file" class="custom-file-input" name="pphoto" /> 
				<label class="custom-file-label">Choose file</label>
				</div>
			</div>
			</div>
			<div class="input-group mb-3">
			
				<div class="input-group-prepend">
					<label class="input-group-text">Category</label>
				</div>
				<select class="custom-select" name="pc" >
					<option selected>Choose...</option>
					<option  value="1">Chain</option>
					<option value="2">Pendants</option>
					<option value="3">Earring</option>
					<option value="4">Finger Rings</option>
					<option value="5">Mangalsutra</option>
					<option value="6">Neckwear</option>
					<option value="7">Nose Pin</option>
					<option value="8">Bangles</option>
				</select>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text">Supply</label>
				</div>
				<select class="custom-select" name="ps">
					<option selected>Choose...</option>
					<option value="1">Rowe, Fritsch and Walker</option>
					<option value="2">Zulauf LLC</option>
					<option value="3">Schumm, Crooks and Rogahn</option>
					<option value="4">Marvin-Barton</option>
				</select>
			</div>
			<div class="form-group">
				<p>Product Summary</p>
				<input class="form-control" name="psummary"
					value="${product.summary}" rows="3"></input>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" name="pbestseller" type="checkbox"
						value="${product.bestseller }">
					<p class="form-check-label">BestSeller</p>
				</div>
				<div></div>
			</div>
			<input type="hidden" name="idnum" value="${product.productId }">
			<button type="submit" class="btn btn-primary ">Update</button>
			<button type="reset" class="btn btn-primary ">Reset</button>
		</form>
	</div>

</div>
</div>
</div>
<jsp:include page="/include/footer.jsp" />
