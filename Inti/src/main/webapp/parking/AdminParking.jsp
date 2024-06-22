<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Parking</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: Arial;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
    }
    .container {
        width: 60%;
        margin: auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    }
    h3,h1 {
        color: black;
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    
    tr:hover {
        background-color: #f1f1f1;
    }
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>Parking Details</h1>
    <div class="container">
        <c:if test="${not empty error_message}">
            <h3>${error_message}</h3>
        </c:if>
    
        <c:if test="${empty error_message}">
            <table>
                <tr>
                    <th>Parking Slot</th>
                    <th>Room Number</th>
                    <th>Status</th>
                    <th>Customer Name</th>
                    <th>Customer ID</th>
                </tr>    
                
                <c:forEach var="parking" items="${parking_details}">
                <tr>
                    <td>${parking.parking_id}</td>
                    <td>${parking.room_number}</td>
                    <td>${parking.status}</td>
                    <td>${parking.customer_name}</td>
                    <td>${parking.customer_id}</td>
                </tr>
                </c:forEach>
            </table>
        </c:if>
         <a href="<%=request.getContextPath()%>/AdminParking" class="btn btn-primary">Back to Admin Parking</a>
    </div>
</body>
</html>