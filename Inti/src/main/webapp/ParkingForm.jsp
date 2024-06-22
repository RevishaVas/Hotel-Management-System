
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parking Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        color: #333;
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    label {
        margin: auto;
        font-size: 16px;
        color: #555;
    }
    input[type="email"] {
        padding: 8px;
        width: 100%;
        max-width: 400px;
        margin: 5px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #28a745;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

</style>
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
		<h2>Welcome to Hotel Parking Facility!</h2>
		<form action="ParkingForm" method="post">
			<label for="emailaddress">Enter your email address used for reservation :</label>
			<input type="email" id="emailaddress" name="email"><br><br>
			
			<input type="submit" value="Click here for your parking details">
		
		
		</form>
</body>
</html>