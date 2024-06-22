<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Room Detail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<c:set var="customerID" value="${sessionScope.customerID}" />
	<c:set var="firstAvailableRooms" value="${firstAvailableRooms}" />
	<c:if test="${empty firstAvailableRooms}">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body text-center">
						<p class="text-danger">No available rooms.</p>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty firstAvailableRooms}">
		<div class="row justify-content-center mt-5">
			<div class="col-md-4">
				<div class="card mb-4">
					<div class="card-body p-4" >
						<p class="card-text mb-3">
							Room Type:
							<c:out value="${firstAvailableRooms.roomType}" />
						</p>
						<p class="card-text mb-3">
							Room View:
							<c:out value="${firstAvailableRooms.roomView}" />
						</p>
						<p class="card-text mb-3">
							Status:
							<c:out value="${firstAvailableRooms.status}" />
						</p>
						<form action="booking" method="post">
							<input type="hidden" name="roomNumber"
								value="<c:out value='${firstAvailableRooms.roomNumber}'/>">
							<input type="hidden" name="roomType"
								value="<c:out value='${firstAvailableRooms.roomType}'/>">
							<input type="hidden" name="roomView"
								value="<c:out value='${firstAvailableRooms.roomView}'/>">
							<input type="hidden" name="customerID"
								value="<c:out value='${customerID}'/>"> <input
								type="hidden" name="checkIn"
								value="<c:out value='${checkInDate}'/>"> <input
								type="hidden" name="checkOut"
								value="<c:out value='${checkOutDate}'/>">
								<button type="submit" class="btn btn-primary">Book Now</button>
								<a href="<%=request.getContextPath()%>/available"
									class="btn btn-secondary">Back to Room Listing</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<div class="container"></div>
</body>
</html>