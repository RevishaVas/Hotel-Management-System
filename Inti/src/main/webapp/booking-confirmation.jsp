<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Confirmation</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
<div class="container mt-3">
    <h1>Booking Confirmation</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Booking Confirmed</h5>
            <p class="card-text">Thank you for your booking.</p>
            <p class="card-text">Room Number: ${roomNumber}</p>
            <p class="card-text">Room Type: ${roomType}</p>
            <p class="card-text">Room View: ${roomView}</p>
            <p class="card-text">Check-in Date: ${checkIn}</p>
            <p class="card-text">Check-out Date: ${checkOut}</p>
            <p class="card-text">Price: ${price}</p>
            <a href="<%=request.getContextPath()%>/available" class="btn btn-primary">Back to Room List</a>
        </div>
    </div>
</div>
</body>
</html>
