<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Rooms</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
<c:set var="customerID" value="${sessionScope.customerID}"/>
    <div class="container">
        <h2>Available Rooms</h2>
        <c:if test="${empty availableRooms}">
            <p class="text-danger">No available rooms.</p>
        </c:if>
        <c:if test="${not empty availableRooms}">
            <div class="row">
                <c:forEach var="room" items="${availableRooms}">
                <c:if test="${room.status != 'Booked'}">
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <div class="card-body">
                                <p class="card-text">Room Type: <c:out value="${room.roomType}"/></p>
                                <p class="card-text">Room View: <c:out value="${room.roomView}"/></p>
                                <p class="card-text">Status: <c:out value="${room.status}"/></p>
                                <form action="booking" method="post">
                                    <input type="hidden" name="roomNumber" value="<c:out value='${room.roomNumber}'/>">
                                    <input type="hidden" name="customerID" value="<c:out value='${customerID}'/>">
                                    <input type="hidden" name="roomType" value="<c:out value='${room.roomType}'/>">
                                    <input type="hidden" name="roomView" value="<c:out value='${room.roomView}'/>">
                                    <input type="hidden" name="checkIn" value="<c:out value='${checkInDate}'/>">
                                    <input type="hidden" name="checkOut" value="<c:out value='${checkOutDate}'/>">
                                    <button type="submit" class="btn btn-primary">Book Now</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>
           <div class="mt-3">
            <a href="<%=request.getContextPath()%>/available" class="btn btn-secondary">Back</a>
        </div>
    </div>
</body>
</html>
