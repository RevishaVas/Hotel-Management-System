<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<style>
/* Base reset and font settings */
body, html {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f4f9;
	color: #333;
}

/* Container styling */
.container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	padding: 20px;
}

/* Form styling */
form {
	background: white;
	padding: 40px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 300px;
}

/* Form elements styling */
label {
	margin-bottom: 5px;
	font-size: 16px;
	color: #555;
}

input[type="text"], input[type="submit"], input[type="date"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 20px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box;
	/* Includes padding and border in element's width/height */
	transition: border-color 0.3s;
}

input[type="text"]:focus, input[type="date"]:focus {
	border-color: #0056b3;
	outline: none;
}

input[type="submit"] {
	background-color: #0056b3;
	color: white;
	font-weight: bold;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #004494;
}

/* Link styling */
a {
	color: #0056b3;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">
		<form action="ProcessCheckout" method="post">
			<h2>Checkout Booking</h2>
			<label for="bookingId">Booking ID:</label> <input type="text"
				id="bookingId" name="bookingId" required="required" /> <label
				for="checkoutDate">Checkout Date:</label> <input type="date"
				id="checkoutDate" name="checkoutDate" required="required" /> <input
				type="submit" value="Mark as Paid" />
		</form>
	</div>
</body>
</html>
