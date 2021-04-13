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


<!-- magnifiner -->
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
</style>
<script>
	
	function mytogglepassword() {
	  var x = document.getElementById("myInputpassword");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
	
function magnify(imgID, zoom) {
  var img, glass, w, h, bw;
  img = document.getElementById(imgID);
  /*create magnifier glass:*/
  glass = document.createElement("DIV");
  glass.setAttribute("class", "img-magnifier-glass");
  /*insert magnifier glass:*/
  img.parentElement.insertBefore(glass, img);
  /*set background properties for the magnifier glass:*/
  glass.style.backgroundImage = "url('" + img.src + "')";
  glass.style.backgroundRepeat = "no-repeat";
  glass.style.backgroundSize = (img.width * zoom) + "px " + (img.height * zoom) + "px";
  bw = 3;
  w = glass.offsetWidth / 2;
  h = glass.offsetHeight / 2;
  /*execute a function when someone moves the magnifier glass over the image:*/
  glass.addEventListener("mousemove", moveMagnifier);
  img.addEventListener("mousemove", moveMagnifier);
  /*and also for touch screens:*/
  glass.addEventListener("touchmove", moveMagnifier);
  img.addEventListener("touchmove", moveMagnifier);
  function moveMagnifier(e) {
    var pos, x, y;
    /*prevent any other actions that may occur when moving over the image*/
    e.preventDefault();
    /*get the cursor's x and y positions:*/
    pos = getCursorPos(e);
    x = pos.x;
    y = pos.y;
    /*prevent the magnifier glass from being positioned outside the image:*/
    if (x > img.width - (w / zoom)) {x = img.width - (w / zoom);}
    if (x < w / zoom) {x = w / zoom;}
    if (y > img.height - (h / zoom)) {y = img.height - (h / zoom);}
    if (y < h / zoom) {y = h / zoom;}
    /*set the position of the magnifier glass:*/
    glass.style.left = (x - w) + "px";
    glass.style.top = (y - h) + "px";
    /*display what the magnifier glass "sees":*/
    glass.style.backgroundPosition = "-" + ((x * zoom) - w + bw) + "px -" + ((y * zoom) - h + bw) + "px";
  }
  function getCursorPos(e) {
    var a, x = 0, y = 0;
    e = e || window.event;
    /*get the x and y positions of the image:*/
    a = img.getBoundingClientRect();
    /*calculate the cursor's x and y coordinates, relative to the image:*/
    x = e.pageX - a.left;
    y = e.pageY - a.top;
    /*consider any page scrolling:*/
    x = x - window.pageXOffset;
    y = y - window.pageYOffset;
    return {x : x, y : y};
  }
}
</script>





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
								<a href="index.jsp"><img src="images/logo.png" alt="#"
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

	<nav class="navbar navbar-expand-lg navbar-dark bg-black "
		style="background-color: black;">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mr-auto">
					<%
					int category = 0;
					%>
					<li class="nav-item "><a class="nav-link"
						href="<%=request.getContextPath()%>">Home</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> JEWELLERY </a>
						<div class="dropdown-menu bg-black"
							style="background-color: black;" aria-labelledby="navbarDropdown">
							<a class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/Category?category=1"
								onclick="<%category = 1;%>">CHAINS</a> <a
								class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/Category?category=2"
								onclick="<%category = 2;%>">PENDANT SETS</a> <a
								class="dropdown-item text-secondary"
								href="<%=request.getContextPath()%>/Category?category=3"
								onclick="<%category = 3;%>">EARRINGS</a> <a
								class="dropdown-item text-secondary"
								href="<%=request.getContextPath()%>/Category?category=4"
								onclick="<%category = 4;%>">FINGER RING</a> <a
								class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/Category?category=5"
								onclick="<%category = 5;%>">MANGLSUTRA</a> <a
								class="dropdown-item text-secondary"
								href="<%=request.getContextPath()%>/Category?category=6"
								onclick="<%category = 6;%>">NECKWEARS</a> <a
								class="dropdown-item text-secondary"
								href="<%=request.getContextPath()%>/Category?category=7"
								onclick="<%category = 7;%>">NOSEPINS</a> <a
								class="dropdown-item text-secondary"
								href="<%=request.getContextPath()%>/Category?category=8"
								onclick="<%category = 8;%>">BANGLES</a>
						</div></li>

					<li class="nav-item"><a class="nav-link color-aqua-hover"
						href="<%=request.getContextPath()%>/Category?category=-1"
						onclick="<%category = -1;%>">Gold</a></li>
					<li class="nav-item"><a class="nav-link color-aqua-hover"
						href="<%=request.getContextPath()%>/Category?category=-2"
						onclick="<%category = -2;%>">Diamond</a></li>
					<li class="nav-item"><a class="nav-link color-aqua-hover"
						href="<%=request.getContextPath()%>/Category?category=-3"
						onclick="<%category = -3;%>">Platinum</a></li>
					<li class="nav-item"><a class="nav-link color-aqua-hover"
						href="<%=request.getContextPath()%>/shop.jsp">Shop</a></li>
					<li class="nav-item"><a class="nav-link color-aqua-hover"
						href="<%=request.getContextPath()%>/shop.jsp">contact</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdow"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fa fa-fw fa-user"></i>
					</a>
						<div class="dropdown-menu bg-black"
							style="background-color: black;" aria-labelledby="navbarDropdow">

							<a class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/Login">LOGIN</a> <a
								class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/SignUp">SIGNUP</a> <a
								class="dropdown-item text-secondary "
								href="<%=request.getContextPath()%>/Admin">ADMIN LOGIN</a>
						</div></li>
					
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-light btn-rounded"
						style="background-color: black;" type="submit">
						<i class="fas fa-search fa-lg"></i>
					</button>
				</form>
			</div>
		</div>
	</nav>




	<!-- end header -->
	<!-- slider -->