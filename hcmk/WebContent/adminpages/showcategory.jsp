<%@page import="hcmk.com.hibernate.DAO.CategoryDAO"%>
<%@page import="hcmk.com.hibernate.entity.Category"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username=null,sessionID=null;
boolean currentLoggedInAdmin=false;
if(request.getSession().getAttribute("username") ==null )
{
	%>
	<jsp:include page="/index.jsp" />
<%
return ;}
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
			
			<%!List<Category> category = CategoryDAO.getAllCategory();%>
			<c:forEach items="<%=category%>" var="cat">

				<div class="card">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-3 col-md-6 col-lg-4 text-dark col-xl-2">
							<i class="far fa-gem fa-8x mt-5 ml-3"></i>

						</div>
						<div class="col-sm-9 col-md-6 col-lg-8 col-xl-10">
							<div class="card">

								<div class="card-header"><h4><span class="text-primary">Category Name</span> : ${cat.categoryName } </h4></div>
								
								<div class="card-body">
									<h5 class="card-title"><span class="text-primary">Category Id</span> :${cat.categoryId }</h5>
									<h5 class="card-title">${cat.categorydes }</h5>
									
									
									<a href="<%=request.getContextPath()%>/ViewCategoryProduct?cid=${cat.categoryId}" class="btn btn-primary">View</a>
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







