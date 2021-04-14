<%@page import="hcmk.com.hibernate.DAO.ProductDAO"%>
<%@page import="hcmk.com.hibernate.DAO.CartDetailDAO"%>
<%@page import="hcmk.com.hibernate.DAO.AddressDAO"%>
<%@page import="hcmk.com.hibernate.DAO.CartDAO"%>
<%@page import="hcmk.com.hibernate.DAO.UsersDAO"%>
<%@page import="hcmk.com.hibernate.entity.Product"%>
<%@page import="hcmk.com.hibernate.entity.Users"%>
<%@page import="hcmk.com.hibernate.entity.Cart"%>
<%@page import="hcmk.com.hibernate.entity.CartDetail"%>
<%@page import="hcmk.com.hibernate.entity.Address"%>
<%@page import="hcmk.com.hibernate.entity.CartDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String username = null, sessionID = null;
String currentLoggedInUser = null;
if (request.getSession().getAttribute("username") == null) {
	session.setAttribute("message", "Your are not logged in please login first to Checkout");
	response.sendRedirect("Login");
} else {
	username = request.getSession().getAttribute("username").toString();
}
%>
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
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700"
	rel="stylesheet">
\
<link href='https://fonts.googleapis.com/css?family=Clicker Script'
	rel='stylesheet'>

<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="style1.css" rel="stylesheet">
<link href="css/login1.css" rel="stylesheet">
<link href="css/signup.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">


<!-- magnifiner -->

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
	<form class="m-5" action="Payment" method="post">
		<div class="row">
			<div class="col-8 bg-light">
				<h1 class="center mt-3">Cart Items</h1>
				<%
				Users buyer = UsersDAO.getUserByUserName(username);
				Cart mycart = CartDAO.getCartByUser(username, false);
				if (mycart == null) {
					Users me = UsersDAO.getUserByUserName(username);
					mycart = CartDAO.createCart(me);
				}
				List<Product> products = CartDetailDAO.getProductByUser(mycart.getCartId());
				List<Product> productcat = new ArrayList<Product>();
				if (products == null) {
					out.print(
					"<p class=\"text-center\"> Look's Like Someone is not able to decide what to buy</p > <br> <p class=\"text-center\">Your Cart is empty</p>");
				} else {
					for (Product pro : products) {
						productcat.add(pro);
					}
				}
				List<CartDetail> items = CartDetailDAO.getCartDetail(mycart);
				%>
				<table class='table'>
					<thead class='thread-dark'>
						<tr>
							<th>Product Name</th>
							<th>Price</th>
							<th>Making Charges</th>
							<th>Quantity</th>
							<th>Total Price</th>

						</tr>
					</thead>
					<%
					int i = 0;
					for (; i < items.size() && i < productcat.size(); i++) {
					%>
					<tr>
						<td><%=productcat.get(i).getProductName()%></td>
						<td><%=productcat.get(i).getPrice()%></td>
						<td><%=productcat.get(i).getMakingCharge()%></td>
						<td><%=items.get(i).getQuantity()%></td>
						<td><%=items.get(i).getTotalPrice()%></td>
					</tr>
					<%
					}
					%>
				</table>
				<div class="container">
					<h4>
						<%
						DecimalFormat df = new DecimalFormat("####0.00");
						%>
						Total Price To Pay:
						<%=df.format(Double.parseDouble(mycart.getGrandTotal()))%>
					</h4>

					<a><button class="btn btn-primary btn-big">TAP TO PAY</button></a>
				</div>
			</div>
			<div class="col-2 bg-light m-5">
				<div class="container m-5">
					<h3>Address</h3>
				</div>
				<%
				List<Address> myaddress = AddressDAO.getAddressList(buyer.getUserName());

				if (myaddress == null) {
				%>
				<button></button>
				<%
				} else {
				%>
				<input type="radio" class="form-check-input"
					value="<%=myaddress.get(0).getAddressId()%>" name="address"
					checked="checked">
				<p><%=myaddress.get(0).getStreetAddress() + " , " + myaddress.get(0).getCity() + " , "
		+ myaddress.get(0).getCountry() + " , " + myaddress.get(0).getPincode()%></p>
				<%
				int index = 1;
				%>

				<%
				for (; index < myaddress.size(); index++) {
				%>
				<input type="radio" class="form-check-input"
					value="<%=myaddress.get(index).getAddressId()%>" name="address">
				<p><%=myaddress.get(index).getStreetAddress() + " , " + myaddress.get(index).getCity() + " , "
		+ myaddress.get(index).getCountry() + " , " + myaddress.get(index).getPincode()%></p>
				<%
				}
				}
				%>
			</div>
		</div>

		<input type="hidden" name="paymentAmount" value="<%=df.format(Double.parseDouble(mycart.getGrandTotal()))%>">
		<input type="hidden" name="mycartId" value="<%=mycart.getCartId() %>">
		<input type="hidden" name="user" value="<%=buyer.getUserName() %>" >
		
		<div class="form-check">
			<input class="form-check-input" type="radio" checked>
			<p>Online Payment Is Available Till Now</p>
		</div>
		<div class="form-check disabled">
			<input class="form-check-input" type="radio" disabled>
			<p>Cash On Delivery Not Available</p>
		</div>
	</form>
	
	<%if(request.getAttribute("payNow")!=null) {%>
<form action="RazorPay" method="POST">
    <script
            src="https://checkout.razorpay.com/v1/checkout.js"
            data-key="rzp_test_GhX8AcBTmCX9Qd"
            data-amount=${amount }
            data-order_id=${razorpayOrderId }
            data-name="Purnima soni"
            data-description="HCMK "
            data-image="images/logo.png"
            data-netbanking="true"
            data-description="HCMK Test"
            data-prefill.name=""
            data-prefill.email=""
            data-prefill.contact=""
            data-notes.shopping_order_id="${cartid }">
    </script>
    <input type="hidden" name="paymentAmount" value="${amount }">
		<input type="hidden" name="mycartId" value="${cartid}">
		<input type="hidden" name="user" value="<%=buyer.getUserName() %>" >
		<input type="hidden" name="address" value="${address }" >
		
    <input type="hidden" name="RzorPayID" value="${razorpayOrderId }">
   
</form>
<%} %>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
</body>
</html>