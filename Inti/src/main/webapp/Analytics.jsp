<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
        /* Custom CSS for the Analytics Page */
        body {
            background-color: #f8f9fa;
          
        }
        .analytics-container {
            max-width: 900px;
            margin: auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .analytics-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #343a40;
        }
        .analytics-container .stats {
            display: flex;
            justify-content: space-around;
            margin-bottom: 30px;
        }
        .analytics-container .stats div {
            text-align: center;
            flex: 1;
            margin: 15px;
            padding: 20px;
            background: #e9ecef;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .analytics-container .stats h3 {
            font-size: 1.3rem;
            margin-bottom: 10px;
            color: #495057;
        }
        .analytics-container .stats p {
            font-size: 1.6rem;
            font-weight: bold;
            color: #007bff;
        }
        .chart-container {
            position: relative;
            height: 400px;
            margin-top: 30px;
        }
        canvas {
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 15px;
        }
    </style>
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
 
    <div class="container analytics-container">
        <h2>Analytics Dashboard</h2>
        <div class="stats row">
            <div class="col-md-4">
                <h3>Total Customers</h3>
                <p>${totalCustomers}</p>
            </div>
            <div class="col-md-4">
                <h3>Total Bookings</h3>
                <p><%= request.getAttribute("totalBookings") %></p>
            </div>
            <div class="col-md-4">
                <h3>Total Available Rooms</h3>
                <p><%= request.getAttribute("totalAvailableRooms") %></p>
            </div>
        </div>
        <div class="chart-container">
        <!-- Canvas element us used for chart rendering  -->
            <canvas id="myChart"></canvas>
        </div>
    </div>
    <script>
    var totalCustomers = ${totalCustomers != null ? totalCustomers : 0};
    var totalBookings = ${totalBookings != null ? totalBookings : 0};
    var totalAvailableRooms = ${totalAvailableRooms != null ? totalAvailableRooms : 0};
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line', // Change from 'bar' to 'line'
        data: {
            labels: ['Total Customers', 'Total Bookings', 'Available Rooms'],
            datasets: [{
                label: 'Statistics',
                data: [
                    <%= request.getAttribute("totalCustomers") %>,
                    <%= request.getAttribute("totalBookings") %>,
                    <%= request.getAttribute("totalAvailableRooms") %>
                ],
                backgroundColor: 'rgba(75, 192, 192, 0.2)', // Light fill color
                borderColor: 'rgba(75, 192, 192, 1)', // Line color
                borderWidth: 2,
                tension: 0.4, // Adds some curvature to the line
                pointBackgroundColor: 'rgba(75, 192, 192, 1)', // Point color
                pointBorderColor: '#fff', // Point border color
                pointHoverBackgroundColor: '#fff', // Hover point fill color
                pointHoverBorderColor: 'rgba(75, 192, 192, 1)' // Hover point border color
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true,
                    grid: {
                        color: 'rgba(200, 200, 200, 0.3)'
                    }
                },
                x: {
                    grid: {
                        color: 'rgba(200, 200, 200, 0.3)'
                    }
                }
            },
            plugins: {
                legend: {
                    labels: {
                        font: {
                            size: 14
                        }
                    }
                },
                tooltip: {
                    backgroundColor: 'rgba(0, 0, 0, 0.7)',
                    titleFont: {
                        size: 16,
                        weight: 'bold'
                    },
                    bodyFont: {
                        size: 14
                    },
                    callbacks: {
                        label: function(tooltipItem) {
                            return tooltipItem.dataset.label + ': ' + tooltipItem.raw;
                        }
                    }
                }
            }
        }
    });
										
    </script>
</body>
</html>