<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: black">
		<div>
			<ul class="navbar-nav navbar-collapse justify-content-start">
				<li><a href="<%=request.getContextPath()%>"
					class="navbar-brand"> Hotel Management App</a></li>
				<%
				String role = (String) request.getSession().getAttribute("role");
				if (role == null || role.equals("customer")) {
				%>
				<li><a href="<%=request.getContextPath()%>/available"
					class="nav-link">Room search</a></li>
				<li><a href="<%=request.getContextPath()%>/ParkingForm"
					class="nav-link">Customer Parking</a></li>
				<%
				}
				%>

				<%
				if (role == null || !role.equals("customer")) {
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
			</ul>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/login"
				class="nav-link">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/register"
				class="nav-link">Signup</a></li>
			<li><a href="<%=request.getContextPath()%>/customerLogin"
				class="nav-link">Customer Login</a></li>
			<%
			if (role == null || role.equals("customer")) {
			%>
			<li><a href="<%=request.getContextPath()%>/user-update"
				class="nav-link">Profile Customer</a></li>
			<%
			}
			%>
		</ul>
	</nav>
</header>