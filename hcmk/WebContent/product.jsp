<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Cart"%>
<%@page import="hcmk.com.hibernate.DAO.CartDAO"%>
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
<%
Cart mycart = CartDAO.getCartByUser(username, false);
%>

<div class="container ">
	<%@include file="message/message.jsp"%>

	<div class="row">

		<div class="col m-3">
			<div class="img-magnifier-container">
				<img id="myimage" class=" border rounded m-3"
					src="${product.photos}" width="600" height="600">
			</div>
		</div>

		<div class="col m-3">
			<div class="container-fluid">
				<div class="card my-5">
					<div class="container">
						<h1>${product.title}</h1>

						<h4 class="text-secondary">Price : ${product.price }</h4>
						<h4 class="text-secondary">Making Charges:
							${product.makingCharge}</h4>
						<h4 class="text-secondary">Purity : ${product.purity}k</h4>
						<p class="text-secondary">${product.summary }${product.metal }
							Jewellery</p>
						<p class="text-secondary">${product.productName}Collections</p>
						<p class="text-secondary">Discount : No Discount on this deal</p>
						<h2>${product.price }</h2>
						<h3>${product.makingCharge}</h3>
						<p class="text-secondary">${product.summary }</p>
						<form action="<%=request.getContextPath()%>/CartAdd" method=post>
							<input type="hidden" name="user" value="${username }"> <input
								type="hidden" name="productId" value="${product.productId}">
							<button type="submit" class="btn btn-promary mb-5">ADD
								TO CART</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="/include/footer.jsp" />