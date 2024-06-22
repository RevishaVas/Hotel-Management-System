<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Parking Details</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
           
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        h3 {
            color: #d9534f;
            text-align: center;
        }
        .parking-block {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .parking-block p {
            margin: 5px 0;
            color: #555;
        }
    </style>
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
	<h2>Parking Details</h2>
    <c:if test="${not empty errorMessage}">
        <h3>${errorMessage}</h3>
    </c:if>
    
    <c:if test="${empty errorMessage}">
    
            <c:forEach var="parking" items="${parkingList}">
            <div class="container">
                <div class="parking-block">
                    <p>Customer_name: ${customer_name}</p>
                    <p>Customer_ID: ${customer_id}</p>
                    <p>Room Number: ${parking.room_number}</p>
                    <p>Parking ID: ${parking.parkingID}</p>
                </div>
            
            </div>
                
            </c:forEach>
        
    </c:if>

</body>
</html>