<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Billing Details</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 0px;
        }
        .container {
            background: white;
            width: 70%;
            max-width: 600px;
            margin: 30px auto;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        .detail {
            margin: 10px 0;
            padding: 8px;
            font-size: 16px;
            border-bottom: 1px solid #ccc;
        }
        .detail label {
            font-weight: bold;
        }
        .detail span {
            float: right;
            color: #555;
        }
        .button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            font-size: 18px;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #45a049;
        }
    </style>
    
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
    <div class="container">
        <h2>Billing Details</h2>
        <form action="Billing/confirmPayment.jsp" method="post">
            <% 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date checkInDate = null;
                Date checkOutDate = null;

                // Retrieve and convert date attributes
                Object checkInObj = request.getAttribute("checkInDate");
                Object checkOutObj = request.getAttribute("checkOutDate");

                if (checkInObj instanceof java.sql.Date) {
                    checkInDate = new Date(((java.sql.Date) checkInObj).getTime());
                }

                if (checkOutObj instanceof java.sql.Date) {
                    checkOutDate = new Date(((java.sql.Date) checkOutObj).getTime());
                }

                // Calculate the number of nights
                long diff = 0;
                if (checkInDate != null && checkOutDate != null) {
                    long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
                    diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                }

                double pricePerNight = 0;
                Object priceObj = request.getAttribute("price");
                if (priceObj instanceof String) {
                    pricePerNight = Double.parseDouble((String) priceObj);
                } else if (priceObj instanceof Number) {
                    pricePerNight = ((Number) priceObj).doubleValue();
                }

                double totalCost = diff * pricePerNight;
            %>
            <div class="detail"><label>Booking ID:</label><span><%= request.getAttribute("bookingId") %></span></div>
            <div class="detail"><label>Customer ID:</label><span><%= request.getAttribute("customerId") %></span></div>
            <div class="detail"><label>Email:</label><span><%= request.getAttribute("email") %></span></div>
            <div class="detail"><label>Check-In Date:</label><span><%= sdf.format(checkInDate) %></span></div>
            <div class="detail"><label>Check-Out Date:</label><span><%= sdf.format(checkOutDate) %></span></div>
            <div class="detail"><label>Room Type:</label><span><%= request.getAttribute("roomType") %></span></div>
            <div class="detail"><label>Room View:</label><span><%= request.getAttribute("roomView") %></span></div>
            <div class="detail"><label>Price per Night:</label><span>€<%= String.format("%,.2f", pricePerNight) %></span></div>
            <div class="detail"><label>Total Nights:</label><span><%= diff %></span></div>
            <div class="detail"><label>Total Cost:</label><span>€<%= String.format("%,.2f", totalCost) %></span></div>
            <input type="submit" value="Confirm Payment" class="button">
        </form>
    </div>
</body>
</html>
