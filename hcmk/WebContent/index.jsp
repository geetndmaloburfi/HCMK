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
<div id="demo" class="carousel slide" data-ride="carousel">

	<!-- Indicators -->
	<ul class="carousel-indicators">
		<li data-target="#demo" data-slide-to="0" class="active"></li>
		<li data-target="#demo" data-slide-to="1"></li>
		<li data-target="#demo" data-slide-to="2"></li>

	</ul>

	<!-- The slideshow -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="images/model13.jpg" alt="photo" width="100%" height="500">
		</div>
		<div class="carousel-item">
			<img src="images/model12.jpeg" alt="photo" width="100%" height="500">
		</div>
		<div class="carousel-item">
			<img src="images/model11.jpg" alt="photo" width="100%" height="500">
		</div>

	</div>

	<!-- Left and right controls -->
	<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
		class="carousel-control-prev-icon"></span>
	</a> <a class="carousel-control-next" href="#demo" data-slide="next"> <span
		class="carousel-control-next-icon"></span>
	</a>
</div>


<hr>
<div class="hr1"></div>
<div class="bestheading">

	<h1 class="Clicker">Best Sellers</h1>
	<hr>
</div>
<div class="space">
	<div class="power">

		<%!List<Product> products = ProductDAO.getBestsellerList();%>
		<div class="rowbest">

			<c:forEach items="<%=products%>" var="product">
				<div class="columnbest">

					<div class="cardbest">
						<img src="${product.photos}" alt="Jane" style="width: 100%">
						<div class="containerbest">

							<h4>${product.title}</h4>
							<p class="titlebest">${product.price}</p>

							<p>
								<a
									href="<%=request.getContextPath()%>/Product?p=${product.productId}"><button
										class="btn btn-info btn-block">View</button></a>
							</p>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>


	</div>
</div>





<jsp:include page="/include/footer.jsp" />