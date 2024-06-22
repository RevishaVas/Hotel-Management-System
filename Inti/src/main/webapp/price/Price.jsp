<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Dynamic Pricing</title>
 <link rel="icon" href="/DynamicPricing/src/main/webapp/travel-holiday-vacation-327_89074.ico">
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
 <style>
 	body 
 	{
		 font-family: Arial;
		 margin: 0;
		 padding: 0;
		 /*background-color: #eddbda;*/
		 background-image: url("blend-metallic-minty-splendor-coins-crafted-into-visual-artistry.jpg");
		 background-repeat: no-repeat;
		 background-size: cover;
 			
	}
	
	
	 h2, h1 
	 {
		 color: white;
		 text-align: center;
	 }
	 form 
	 {
		 max-width: 400px;
		 margin: 20px auto;
		 padding: 20px;
		 background-color: #fff;
		 border-radius: 5px;
		 box-shadow: 5px;
	 }
	 label 
	 {
	 	display: block;
	 	margin-bottom: 8px;
	 	color: #333;
	 }
 	select 
 	{
		 width: 100%;
		 padding: 8px;
		 border-radius: 4px;
		 margin-bottom: 16px;
		 font-size: 16px;
 	}
 input[type="submit"] 
 {
	 background-color: #7a26e0;
	 color: #fff;
	 padding: 10px 20px;
	 border: none;
	 border-radius: 4px;
	 cursor: pointer;
	 font-size: 16px;
 }
 #message 
 {
	 color: green;
	 text-align: center;
	 margin-top: 20px;
 }
 </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<h2>Welcome to Dynamic Pricing!</h2>
	
<c:if test="${not empty result}">
 	<div id="message">${result}</div>
</c:if>

<c:if test="${not empty current_price}">
 	<div id="message">Current Price: ${current_price}</div>
</c:if>

<c:if test="${not empty updated_price}">
 	<div id="message">Updated Price: ${updated_price}</div>
</c:if>

<c:choose>
 <c:when test="${empty current_price}">
 <form action="PriceForm" method="post">
 <label for="RoomType">Select Room Category :</label>
	 <select id="RoomType" name="roomtype" required>
	 <option value="SuperDeluxe">Super Deluxe</option>
	 <option value="Deluxe">Deluxe</option>
	 <option value="Standard">Standard</option>
	 </select><br><br>
	 
 <label for="RoomView">Select Room Type :</label>
	 <select id="RoomView" name="roomview" required>
	 <option value="SeaView">Sea View</option>
	 <option value="PoolView">Pool View</option>
	 <option value="DuskView">Dusk View</option>
	 </select><br><br>
	 
 <input type="submit" name="action" value="Get Price">
 </form>
 </c:when>
 
<c:otherwise>
 <form action="PriceForm" method="post">
	 <input type="hidden" name="roomtype" value="${param.roomtype}">
	 <input type="hidden" name="roomview" value="${param.roomview}">
	 <input type="hidden" name="action" value="updatePrice">
	 
 <label for="option">Choose an Option :</label>
	 <select id="option" name="opt" required>
	 <option value="increase">Increase</option>
	 <option value="decrease">Decrease</option>
	 </select><br><br>
	 
 		<label for="percentage">Choose the percentage :</label>
			 <select id="percentage" name="per" required>
			 <option value="10">10%</</option>
			 <option value="20">20%</option>
			 <option value="30">30%</option>
			 <option value="40">40%</option>
			 <option value="50">50%</option>
			 <option value="60">60%</option>
			 <option value="70">70%</option>
			 <option value="80">80%</option>
			 <option value="90">90%</option>
			 </select><br><br>
 		<input type="submit" value="Update Price">
 	</form>
 </c:otherwise>
 
</c:choose>

</body>

</html>



