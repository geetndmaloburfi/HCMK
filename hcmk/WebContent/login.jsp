<jsp:include page="/include/header.jsp" />


<div class="one">
	<section>
		<div class="main">
			<p class="sign" align="center">Sign in</p>
			<form class="form1" action="<%=request.getContextPath()%>/User"
				method="post">
				<p class="ungiven">Username</p>
				<input class="un " type="text" name="userName" required />

				<p class="ungiven">password</p>
				<input class="un username" name="password" type="password"
					id="myInputpassword" required /><br>
				
				<input type="checkbox" style="margin-left: 170px"
				onclick="mytogglepassword()"> <span
				style="color: black; margin-bottom: 100px;">Show Password</span>
				

				<input type="submit" value="Sing in" class="submit">

				<p class="signuplogin">
					New User <a class="forgot"
						href="<%=request.getContextPath()%>/SignUp">Create New Account</a>
				<p>
				<p align="center">
					<a href="#" class="forgot">Forgot Password?</a>
				</p>
			</form>


		</div>




	</section>

</div>
















<jsp:include page="/include/footer.jsp" />