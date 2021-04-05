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
<div class="one">
<hr>
<div class="hr1"></div>
<div class="bestheading">

	<h1 class="Clicker">Hukam Chand Mukesh Kumar Saraf</h1>
</div>
<hr>
<div class="hr1"></div>
<div class="beechme">
<h1 class="lowei">Find Us Here</h1>
<hr>
	<iframe
		src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3501.3114088669568!2d77.18542831744385!3d28.650393!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390d029beb97a6e9%3A0x97d0471ef5fe4f03!2sHukam%20Chand%20Mukesh%20Kumar%20Saraf!5e0!3m2!1sen!2sin!4v1615152707067!5m2!1sen!2sin"
		width="800" height="600" style="border: 0;" allowfullscreen=""
		loading="lazy"></iframe>
</div>
</div>
<jsp:include page="/include/footer.jsp" />