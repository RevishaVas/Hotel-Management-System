<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Options</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding-top: 60px; /* Adjusted to not overlap with the navbar */
        }
        .container {
            background: white;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 350px; /* Adjust width as necessary */
            margin: auto; /* Center the container */
        }
        h2 {
            text-align: center;
            color: #333;
            font-size: 24px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
            font-size: 16px;
        }
        input[type="text"], input[type="checkbox"] {
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        .checkbox-group {
            display: flex;
            align-items: center;
        }
        .checkbox-label {
            margin-left: 8px;
            font-size: 16px;
        }
        button {
            padding: 12px;
            font-size: 18px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
            
        }
         .navbar-custom {
            background-color: #000000 !important; /* Ensures the navbar is fully black */
        }
        .navbar-dark .navbar-brand,
        .navbar-dark .navbar-nav .nav-link {
            color: white; /* Ensures text is white for visibility */
        }
    </style>
</head>
<body>
    <<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-custom fixed-top">
        <a class="navbar-brand" href="#">Hotel Management App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/CheckInServlet"class="nav-link">CheckIn</a></li>
                <li><a href="<%=request.getContextPath()%>/ProcessCheckout"class="nav-link">ProcessCheckout</a></li>
                <li><a href="<%=request.getContextPath()%>/available"class="nav-link">Room search</a></li>
                <li><a href="<%=request.getContextPath()%>/assign-room"class="nav-link">Employee assign to room</a></li>
                <li><a href="<%=request.getContextPath()%>/AdminParking"class="nav-link">Admin Parking</a></li>
                <li><a href="<%=request.getContextPath()%>/PriceForm"class="nav-link">Dynamic Pricing</a></li>
                <li><a href="<%=request.getContextPath()%>/ParkingForm"class="nav-link">Customer Parking</a></li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <h2>Payment Options</h2>
        <form action="processPayment.jsp" method="post">
            <label for="amount">Amount:</label>
            <input type="text" id="amount" name="amount" required>
            <div class="checkbox-group">
                <input type="checkbox" id="creditCard" name="paymentMethod" value="creditCard">
                <label for="creditCard" class="checkbox-label">Credit/Debit Card</label>
            </div>
            <div class="checkbox-group">
                <input type="checkbox" id="paypal" name="paymentMethod" value="paypal">
                <label for="paypal" class="checkbox-label">PayPal</label>
            </div>
            <div class="checkbox-group">
                <input type="checkbox" id="bankTransfer" name="paymentMethod" value="bankTransfer">
                <label for="bankTransfer" class="checkbox-label">Bank Transfer</label>
            </div>
            <div class="checkbox-group">
                <input type="checkbox" id="terms" name="terms" required>
                <label for="terms" class="checkbox-label">I agree to the Terms and Conditions</label>
            </div>
            <button type="submit">Proceed to Pay</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</body>
</html>
