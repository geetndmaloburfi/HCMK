<%
	String message=null;
	if(request.getSession().getAttribute("message") !=null)
	{
		message=request.getSession().getAttribute("message").toString();
		%>
		<div class="container">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <strong >${message}</strong> 
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</div>	
		
	<%
		request.getSession().removeAttribute("message");
	
	}
%>