<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>AdminParking</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;

        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 16px;
        }
        input[type="radio"] {
            margin: 10px 0;
        }
        #searchField {
            margin-top: 10px;
        }
        input[type="text"] {
            padding: 8px;
            width: 100%;
            margin-top: 10px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
    <form action="AdminParking" method="post">
    	<h2>Welcome to Admin Parking!</h2><br>
    	<p>Please select your option:</p><br>
        <input type="radio" name="option" value="view" checked onclick="showSearchField(this)">Select here to view all parking details<br>
        <input type="radio" name="option" value="search" onclick="showSearchField(this)">Search by room number<br>
        <div id="searchField" style="display: none;">
            <input type="text" name="searchValue" id="searchValue" oninput="updateOptionValue(this)"> Enter the Room Number <br>
        </div>
        <input type="submit" value="Submit">
    </form>
    
    <script>
        function showSearchField(radio) {
            var searchField = document.getElementById("searchField");
            if (radio.value === "search") {
                searchField.style.display = "block";
            } else {
                searchField.style.display = "none";
                document.getElementById("searchValue").value = "";
            }
        }

       
    </script>
</body>
</html>