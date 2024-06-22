<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Employee Management</a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/CheckInServlet"class="nav-link">CheckIn</a></li>
                <li><a href="<%=request.getContextPath()%>/ProcessCheckout"class="nav-link">ProcessCheckout</a></li>
                <li><a href="<%=request.getContextPath()%>/assign-room"class="nav-link">Employee assign to room</a></li>
                <li><a href="<%=request.getContextPath()%>/AdminParking"class="nav-link">Admin Parking</a></li>
                <li><a href="<%=request.getContextPath()%>/PriceForm"class="nav-link">Dynamic Pricing</a></li>

            </ul>
            <ul class="navbar-nav navbar-collapse justify-content-end">
                <li><a href="<%=request.getContextPath()%>/logout" class="nav-link">Logout</a></li>
            </ul>
        </nav>
    </header>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${employee != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${employee == null}">
                    <form action="insert" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${employee != null}">
                            Edit Employee
                        </c:if>
                        <c:if test="${employee == null}">
                            Add New Employee
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                </c:if>
                <fieldset class="form-group">
                    <label>First Name</label> 
                    <input type="text"
                        value="<c:out value='${employee.firstName}' />" class="form-control"
                        name="firstName" required="required" minlength="2">
                </fieldset>
                <fieldset class="form-group">
                    <label>Role</label> 
                    <input type="text"
                        value="<c:out value='${employee.role}' />" class="form-control"
                        name="role" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Shift</label> 
                    <input type="text"
                        value="<c:out value='${employee.shift}' />" class="form-control"
                        name="shift" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Status</label> 
                    <select class="form-control" name="status">
                        <option value="false" <c:if test="${!employee.status}">selected</c:if>>Inactive</option>
                        <option value="true" <c:if test="${employee.status}">selected</c:if>>Active</option>
                    </select>
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
