package com.hotelmanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.CustomerDao;
import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Customer;

@WebServlet("/CheckInServlet")
public class CheckinController extends HttpServlet {
    private CustomerDao customerDAO;
    private BookingDao bookingDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize your DAO here
        this.customerDAO = new CustomerDao();
        this.bookingDAO = new BookingDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the check-in form page
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkin/checkin.jsp");
        dispatcher.forward(request, response);
        System.out.println("inside");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookingChecked = request.getParameter("bookingChecked");
        String walkinChecked = request.getParameter("walkinChecked");
        String bookingId = request.getParameter("bookingId");
        String firstName = request.getParameter("firstName");
        System.out.println("Booking Checked: " + bookingChecked);
        System.out.println("Walk-in Checked: " + walkinChecked);

        if ("true".equals(bookingChecked)) {
            // Booking ID checkbox was checked, process accordingly
            if (bookingId != null && !bookingId.trim().isEmpty()) {
                checkInWithBookingId(Integer.parseInt(bookingId), request, response);
            } else {
                // Handle error: Booking ID was required but not provided
                response.sendRedirect("checkin/error.jsp");
            }
        } else if ("true".equals(walkinChecked)) {
            System.out.println("Walk-in Checked: " + walkinChecked);
            if (firstName != null && !firstName.trim().isEmpty()) {
                walkInCheckIn(request, response);
            } else {
                System.out.print("inner else");
                // Handle error: First Name was required but not provided
                response.sendRedirect("checkin/error.jsp");
            }
        }
    }

    private void checkInWithBookingId(int bookingId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Retrieve the booking using the provided booking ID
            Booking booking = bookingDAO.getBookingById(bookingId);
            if (booking != null) {
                // Set booking details as request attributes
                request.setAttribute("bookingId", booking.getBookingId());
                request.setAttribute("customerId", booking.getCustomerId());
                request.setAttribute("email", booking.getEmail());
                request.setAttribute("checkInDate", booking.getCheckInDate());
                request.setAttribute("checkOutDate", booking.getCheckOutDate());
                request.setAttribute("roomType", booking.getRoomType());
                request.setAttribute("roomView", booking.getRoomView());
                request.setAttribute("price", booking.getPrice());
                
                System.out.println(booking.getPrice());

                // Forward to the booking-specific success page
                RequestDispatcher dispatcher = request.getRequestDispatcher("/checkin/Bookingjsp.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle case where the booking is not found
                response.sendRedirect("checkin/error.jsp");
            }
        } catch (ClassNotFoundException | SQLException | ServletException e) {
            e.printStackTrace();
            response.sendRedirect("checkin/error.jsp");
        }
    }

    private void walkInCheckIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Extract and handle walk-in guest data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        Customer customer = new Customer(firstName, lastName, email, phone, address);
        
        System.out.println("inside customer regestering" + firstName + lastName + email + phone + address);
        try {
        	int customerID= customerDAO.addCustomer(customer);
            HttpSession session = request.getSession();
            session.setAttribute("customerID",customerID);
            System.out.println(customerID + "customer.getCustomerId()");
    		 session.setAttribute("email", email);
            response.sendRedirect("available"); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("checkin/error.jsp");
        }
    }
}
