<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
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
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">
					Hotel Management App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
				<%
				String role = (String) request.getSession().getAttribute("role");
		        if (!role.equals("customer")) {
				%>
				<li><a href="<%=request.getContextPath()%>/CheckInServlet"
					class="nav-link">CheckIn</a></li>
					<li><a href="<%=request.getContextPath()%>/ProcessCheckout"
					class="nav-link">ProcessCheckout</a></li>
					<li><a href="<%=request.getContextPath()%>/assign-room"
					class="nav-link">Employee assign to room</a></li>
				<li><a href="<%=request.getContextPath()%>/AdminParking"
					class="nav-link">Admin Parking</a></li>
				<li><a href="<%=request.getContextPath()%>/PriceForm"
					class="nav-link">Dynamic Pricing</a></li>
					<li><a href="<%=request.getContextPath()%>/Analytics"
					class="nav-link">Analytics</a></li>
				<%
				}
				%>
				
				<li><a
					href="<%=request.getContextPath()%>/available"
					class="nav-link">Room search</a></li>
				
				<li><a href="<%=request.getContextPath()%>/ParkingForm"
					class="nav-link">Customer Parking</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
					
			</ul>
		</nav>
	</header>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Role</th>
						<th>Shift</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${listEmployee}">
						<tr>
							<td><c:out value="${employee.firstName}" /></td>
							<td><c:out value="${employee.role}" /></td>
							<td><c:out value="${employee.shift}" /></td>
							<td><c:out
									value="${employee.status ? 'Active' : 'Inactive'}" /></td>
							<td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
