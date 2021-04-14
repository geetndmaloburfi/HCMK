<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
</head>
<body>

<form action="/payment/charge" method="POST">
    <script
            src="https://checkout.razorpay.com/v1/checkout.js"
            data-key="rzp_test_GhX8AcBTmCX9Qd"
            data-amount=${amount }
            data-order_id=${razorpayOrderId }
            data-name="Purnima soni"
            data-description="HCMK "
            data-image="/images/logo.png"
            data-netbanking="true"
            data-description="HCMK Test"
            data-prefill.name="Purnima soni"
            data-prefill.email="Purnima@razorpay.com"
            data-prefill.contact="9999999999"
            data-notes.shopping_order_id="${cartid }">
    </script>
    <input type="hidden" name="shopping_order_id" value="${cartid }">
</form>
</body>
</html>