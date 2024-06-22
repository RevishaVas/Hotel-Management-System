<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Form</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
}

.form-section {
	background: #fff;
	padding: 30px;
	margin: 50px auto;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-section h2 {
	margin-bottom: 30px;
}

.btn-custom {
	background-color: #007bff;
	color: #fff;
	border: none;
	margin-right: 20px;
}

.btn-custom:hover {
	background-color: #0056b3;
}

.button-container {
	display: flex;
}
</style>
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<div class="form-section">
			<h2>Feedback Form</h2>
			<form action="submitFeedback" method="post">
				<div class="form-group">
					<label for="name">Name</label> <input type="text"
						class="form-control" id="name" name="name" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" required>
				</div>
				<div class="form-group">
					<label for="rating">How would you rate your experience?</label> <select
						class="form-control" id="rating" name="rating" required>
						<option value="" disabled selected>Select your option</option>
						<option value="1">1 - Very Poor</option>
						<option value="2">2 - Poor</option>
						<option value="3">3 - Average</option>
						<option value="4">4 - Good</option>
						<option value="5">5 - Excellent</option>
					</select>
				</div>
				<div class="form-group">
					<label for="comments">Comments</label>
					<textarea class="form-control" id="comments" name="message"
						rows="5" required></textarea>
				</div>
				<div class="button-container">
					<button type="submit" class="btn btn-custom">Submit
						Feedback</button>

					<button href="<%=request.getContextPath()%>/user-update" class="btn btn-custom">Go back to
						Profile</button>
				</div>
			</form>
		</div>
	</div>
	<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfR+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJTY6mcw6Ck1IN1sIOdhbWFS2xql7F5GOI1ARgxgITbZVj02"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIyFZ7xUpnCJA7lMwGp1cE6Phxlo6ABlixKGA2E"
		crossorigin="anonymous"></script> -->
</body>
</html>