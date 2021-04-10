<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hcmk | home</title>

<!-- site icon and fonts-->
<link rel="icon" href="images/favicon.ico" type="image/png" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">\
<link href='https://fonts.googleapis.com/css?family=Clicker Script' rel='stylesheet'>

<!-- Custom styles for this template -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="style1.css" rel="stylesheet">
<link href="css/login1.css" rel="stylesheet">
<link href="css/signup.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<style>
* {
	box-sizing: border-box;
}

.img-magnifier-container {
	position: relative;
}

.img-magnifier-glass {
	position: absolute;
	border: 3px solid #000;
	cursor: none;
	/*Set the size of the magnifier glass:*/
	width: 150px;
	height: 150px;
}

#warning {
	display: none;
	color: red;
}

.vl {
  border-left: 6px black;
  height: 500px;
}

</style>
</head>

<body id="home_page" class="home_page">
	
	<!-- header -->
	<header class="header">

		<div class="header_top_section">
			<div class="container">
				<div class="row">
					<div class="col-lg-3">
						<div class="full">
							<div class="logo">
								<a href="#"><img src="images/logo.png" alt="#"
									width="120" height="100" /></a>
							</div>
						</div>
					</div>
					<div class="col-lg-9 site_information">
						<div class="full">
							<div class="top_section_info">
								<ul>
									<li>Contact Us: <img src="images/i1.png" alt="#" /> <a
										href="#">( +91 00000 00000 )</a></li>
									<li><img src="images/i2.png" alt="#" /> <a href="#">dummy@gmail.com</a></li>
									<li><img src="images/i3.png" alt="#" /> <a href="#">202
											Karol bagh, Delhi </a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<hr>
<div class="container-fluid">
	<div class="row">
		<div class=" bg-black text-white col-12 col-md-3 col-xl-2 bd-sidebar"
			style="background-color: black;">
			<div class=" mt-3 mb-3">
				<h2 class="text-muted">HCMK ADMIN PENAL</h2>
				<%int getlink=0; %>
				<ul class="nav nav-tabs flex-column">
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=1;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=1">VIEW ALL PRODUCTS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=2;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=2">ADD PRODUCTS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=4;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=3">ALL CATEGORY</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=6;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=4">VIEW USERS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=7;%>" href="#">VIEW ORDERS</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=8;%>" href="<%=request.getContextPath()%>/ValidateAdmin?getlink=6">ADD ADMIN</a></li>
					<li class="nav-item"><a class="nav-link text-white" onclick="<% getlink=8;%>" href="<%=request.getContextPath()%>/Logout">Log Out</a></li>
					
				</ul>
			</div>
		</div>
		