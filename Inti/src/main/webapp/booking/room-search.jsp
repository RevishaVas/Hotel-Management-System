<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room Search</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            cursor: pointer;
        }
        .card.selected {
            border: 2px solid #007bff;
        }
    </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container mt-3">
    <h1>Room Search</h1>
    <form id="room-search-form" action="<%=request.getContextPath()%>/available" method="post">
        <div class="form-group">
            <label for="checkIn">Check-In Date</label>
            <input type="date" id="checkIn" name="checkIn" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="checkOut">Check-Out Date</label>
            <input type="date" id="checkOut" name="checkOut" class="form-control" required>
        </div>
        <input type="hidden" id="selectedRoomType" name="roomType">
        <input type="hidden" id="selectedRoomView" name="roomView">
        <input type="hidden" id="selectedPrice" name="price">
    </form>
    <div class="row mt-3">
        <c:forEach var="category" items="${categories}">
            <div class="col-md-4 mb-3">
                <div class="card" data-room-type="${category.roomType}" data-room-view="${category.roomView}">
                    <div class="card-body">
                        <h5 class="card-title">${category.roomType}</h5>
                        <p class="card-text">${category.roomView}</p>
                        <p class="card-text">${category.price}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
        	const today = new Date().toISOString().split('T')[0];
            document.getElementById("checkIn").setAttribute('min', today);
            document.getElementById("checkOut").setAttribute('min', today);
            
            const cards = document.querySelectorAll('.card');
            const form = document.getElementById('room-search-form');
            const selectedRoomType = document.getElementById('selectedRoomType');
            const selectedRoomView = document.getElementById('selectedRoomView');
            const price = document.getElementById('selectedPrice');
            const checkIn = document.getElementById('checkIn');
            const checkOut = document.getElementById('checkOut');

            cards.forEach(card => {
                card.addEventListener('click', function() {
                    if (!checkIn.value || !checkOut.value) {
                        alert('Please fill out the check-in and check-out dates before selecting a room.');
                        return;
                    }

                    cards.forEach(c => c.classList.remove('selected'));
                    card.classList.add('selected');

                    selectedRoomType.value = card.getAttribute('data-room-type');
                    selectedRoomView.value = card.getAttribute('data-room-view');
                    selectedPrice.value = card.getAttribute('data-price');
                    
                    form.submit();
                });
            });
        });
    </script>
</div>
</body>
</html>
