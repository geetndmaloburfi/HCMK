<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username=null,sessionID=null;
if(request.getSession().getAttribute("username") ==null)
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
								<button  class="buttonbest"><a href="<%=request.getContextPath()%>/Product?p=${product.productId}">View</a></button>
							</p>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>


	</div>
</div>

<jsp:include page="/include/footer.jsp" />