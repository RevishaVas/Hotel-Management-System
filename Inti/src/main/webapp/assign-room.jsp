<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assign Room to Employee</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>

<div class="container mt-3">
    <h1>Assign Room to Employee</h1>
    <form action="assign-room" method="post">
        <div class="form-group">
            <label for="employeeID">Select Employee</label>
            <select id="employeeID" name="employeeID" class="form-control" required>
                <c:forEach var="employee" items="${employees}">
                    <option value="${employee.id}">
                        ${employee.firstName} - ${employee.role}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="roomNumber">Select Room</label>
            <select id="roomNumber" name="roomNumber" class="form-control" required>
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.roomNumber}">
                        Room ${room.roomNumber} - ${room.roomType} (${room.roomView})
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Assign Room</button>
    </form>
    <hr>
    <h2>Current Assignments</h2>
    <c:if test="${empty assignments}">
        <p class="text-danger">No current assignments.</p>
    </c:if>
    <c:if test="${not empty assignments}">
        <div class="row">
            <c:forEach var="assignment" items="${assignments}">
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Room Number: <c:out value="${assignment.roomNumber}"/></h5>
                            <p class="card-text">Employee ID: <c:out value="${assignment.employeeID}"/></p>
                            <p class="card-text">Assigned Time: <c:out value="${assignment.assignedTime}"/></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <div class="mt-3">
        <a href="clear-assignments" class="btn btn-secondary">Clear Assignments</a>
    </div>
</div>
</body>
</html>
