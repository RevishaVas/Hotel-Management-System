<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management App</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            width: 100%;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }
        header {
            width: 100%;
            background-color: tomato;
            margin: 0;
        }
        /* .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            width: 100%;
            box-sizing: border-box;
        }
        .nav-brand a {
            color: white;
            text-decoration: none;
            font-size: 20px;
        }
        .nav-links {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }
        .nav-links li {
            padding: 0 15px;
        }
        .nav-link {
            color: white;
            text-decoration: none;
            font-size: 16px;
        }
        .nav-link:hover {
            text-decoration: underline;
        } */
        .container {
            width: 100%;
            max-width: 500px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            margin-top: 60px;
            background-color: white;
            border-radius: 8px;
            box-sizing: border-box;
        }
        h2 {
            color: #333;
            margin: 0 0 20px 0;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-group {
            width: 100%;
            margin-bottom: 20px;
        }
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="tel"],
        .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .form-group input[type="checkbox"] {
            margin-top: 10px;
        }
        input[type="text"], input[type="number"], button {
            width: 90%;
            padding: 12px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            width: 50%;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
   <%--  <header>
        <nav class="navbar">
            <div class="nav-brand"><a href="<%=request.getContextPath()%>/list">Hotel Management App</a></div>
            <ul class="nav-links">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Check in</a></li>
                <li><a href="<%=request.getContextPath()%>/employee" class="nav-link">Employee</a></li>
                <li><a href="<%=request.getContextPath()%>/logout" class="nav-link">Logout</a></li>
            </ul>
        </nav>
    </header> --%>
    <div class="container">
        <h2>Welcome to Check-In</h2>
        <form action="<%=request.getContextPath()%>/CheckInServlet" method="post">
            <div class="form-group">
                <input type="checkbox" name="type" id="booking_id" onclick="updateCheckboxState()">
                <label for="booking_id">Check-In with Booking ID</label>
                <input type="number" name="bookingId" placeholder="Enter Booking ID">
                <input type="hidden" name="bookingChecked" value="false">
            </div>
            <div class="form-group">
                  	<input type="checkbox" name="walkinChecked" id="walk_in" onclick="updateCheckboxState()">
        			<label for="walk_in">Walk-In Check-In</label>
			        <input type="text" name="firstName" placeholder="Enter First Name">
			        <input type="text" name="lastName" placeholder="Enter Last Name">
			        <input type="email" name="email" placeholder="Enter Email ID">
			        <input type="tel" name="phoneNumber" placeholder="Enter Phone Number">
			        <input type="text" name="address" placeholder="Enter Address">
   
            </div>
            <button type="submit">Check In</button>
        </form>
    </div>
    <script>
        function updateCheckboxState() {
            var bookingCheckbox = document.getElementById('booking_id');
            var walkinCheckbox = document.getElementById('walk_in');
            document.getElementsByName('bookingChecked')[0].value = bookingCheckbox.checked ? "true" : "false";
            document.getElementsByName('walkinChecked')[0].value = walkinCheckbox.checked ? "true" : "false";
            
            if (bookingCheckbox.checked && walkinCheckbox.checked) {
                if (bookingCheckbox === document.activeElement) { // booking_id was just clicked
                    walkinCheckbox.checked = false;
                    document.getElementsByName('walkinChecked')[0].value = "false";
                } else { // walk_in was just clicked
                    bookingCheckbox.checked = false;
                    document.getElementsByName('bookingChecked')[0].value = "false";
                }
            }
        }
    </script>
</body>
</html>
