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
		
			<h1 class="center mt-3">All products in system</h1>
			
			<%!List<Product> products = ProductDAO.getAllProducts();%>
			<c:forEach items="<%=products%>" var="product">

				<div class="card">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-3 col-md-6 col-lg-4 col-xl-2">
						<hr>
							<img class="card-img mt-3 mb-3" src="${product.photos }" style="width: 100%"
								alt="Card image">
								<hr>

						</div>
						<div class="col-sm-9 col-md-6 col-lg-8 col-xl-10">
							<div class="card">

								<div class="card-header"><h4>${product.productName } <span class="text-primary">Product Id</span> : ${product.productId }</h4></div>
								<div class="card-body">
									<h5 class="card-title">${product.title }</h5>
									
									<p class="card-text">${product.summary }  <span class="text-primary">Price </span>:
									${product.price }<span class="text-primary">   Making Charges </span>: ${product.makingCharge}
									</p>
									<a href="<%=request.getContextPath()%>/Product?p=${product.productId}&admin=true" class="btn btn-primary">View/Update</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>

			</c:forEach>
		</div>
	</div>
</div>


<jsp:include page="/include/footer.jsp" />







