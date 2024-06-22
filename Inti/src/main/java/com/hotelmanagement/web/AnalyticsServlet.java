package com.hotelmanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hotelmanagement.dao.BookingsDAO;
import com.hotelmanagement.dao.CustomerDao;
import com.hotelmanagement.dao.RoomsDAO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/Analytics")
public class AnalyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private CustomerDao customerDAO = new CustomerDao();
	    private BookingsDAO bookingDAO = new BookingsDAO();
	    private RoomsDAO roomDAO = new RoomsDAO();
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalCustomers = customerDAO.getTotalCustomers();
        int totalBookings = bookingDAO.getTotalBookings();
        int totalAvailableRooms = roomDAO.getTotalAvailableRooms();
        
        System.out.println("Total Customers: " + totalCustomers);
        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Total Available Rooms: " + totalAvailableRooms);
        
        
        request.setAttribute("totalCustomers", totalCustomers);
        request.setAttribute("totalBookings", totalBookings);
        request.setAttribute("totalAvailableRooms", totalAvailableRooms);
        request.getRequestDispatcher("Analytics.jsp").forward(request, response);
	}
}