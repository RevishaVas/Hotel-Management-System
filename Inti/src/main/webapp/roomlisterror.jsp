<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-3">
    <h1>Error</h1>
    <div class="alert alert-danger">
        <p>${error}</p>
    </div>
    <a href="<%=request.getContextPath()%>/room-search" class="btn btn-primary">Back to Room Search</a>
</div>
</body>
</html>
