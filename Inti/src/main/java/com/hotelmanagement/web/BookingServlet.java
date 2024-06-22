package com.hotelmanagement.web;

import com.hotelmanagement.dao.AvailabilityRoomDAO;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.BookingsDAO;
import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Bookings;
import com.hotelmanagement.model.AvailabilityRoom;
import com.hotelmanagement.dao.CategoryDAO;
import com.hotelmanagement.model.Category;
import com.hotelmanagement.model.Room;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	BookingDao bookingDAO = new BookingDao();
    	
    	int bookingID = Integer.parseInt(request.getParameter("bookingID"));
    	
    	try {
			Booking booking = bookingDAO.getBookingById(bookingID);
			
			String roomNumber = request.getParameter("roomNumber");
	        String checkIn = request.getParameter("checkIn");
	        String checkOut = request.getParameter("checkOut");

	        request.setAttribute("bookingId", booking.getBookingId());
	        request.setAttribute("customerId", booking.getCustomerId());
	        request.setAttribute("email", booking.getEmail());
	        request.setAttribute("roomType", booking.getRoomType());
	        request.setAttribute("roomView", booking.getRoomView());
	        request.setAttribute("price", booking.getPrice());
	        
	        request.setAttribute("roomNumber", roomNumber);
	        request.setAttribute("checkIn", checkIn);
	        request.setAttribute("checkOut", checkOut);

	        request.getRequestDispatcher("/booking-confirmation.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	System.out.println(session.getAttribute("customerID")+ "hit here session.getAttribute(\"customerID\")");
    	int customerID = (int) session.getAttribute("customerID");
    	String email = (String) session.getAttribute("email");
    	
    	CategoryDAO categoryDAO = new CategoryDAO();
    	
    	System.out.println(customerID + "customerID");
    	System.out.println(customerID +"sdfsdf"+ email + "email");
    	int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String roomType = request.getParameter("roomType");
        String roomView = request.getParameter("roomView");
        String checkInStr = request.getParameter("checkIn");
        String checkOutStr = request.getParameter("checkOut");
        Category category = categoryDAO.getByTypeCategories(roomType,roomView);
        int price = category.getPrice();

        Date checkIn = null;
        Date checkOut = null;
        try {
            checkIn = Date.valueOf(checkInStr);
            checkOut = Date.valueOf(checkOutStr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
            return;
        }
 
        Bookings booking = new Bookings();
        booking.setCustomerID(customerID);
        booking.setEmail(email);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);
        booking.setRoomType(roomType);
        booking.setRoomView(roomView);
        booking.setPrice(price);

        BookingsDAO bookingDAO = new BookingsDAO();
        int bookingID = bookingDAO.addBooking(booking);

        // update room availability after booking
        AvailabilityRoom availabilityRoom = new AvailabilityRoom(); 
		  availabilityRoom.setBookingId(bookingID);
		  availabilityRoom.setRoomNumber(roomNumber);
		  availabilityRoom.setStatus("Booked"); 
		  availabilityRoom.setRoomType(roomType);
		  availabilityRoom.setRoomView(roomView); 
		  availabilityRoom.setCheckIn(checkIn);
		  availabilityRoom.setCheckOut(checkOut);
		  
		  AvailabilityRoomDAO availabilityRoomDAO = new AvailabilityRoomDAO();
		    if (availabilityRoomDAO.isRoomAvailable(availabilityRoom)) {
		        availabilityRoomDAO.updateAvailabilityRoom(availabilityRoom);
		    } else {
		        availabilityRoomDAO.insertAvailabilityRoom(availabilityRoom);
		    }

		 

        // redirect to booking confirmation
        response.sendRedirect("booking?bookingID=" + bookingID + "&roomNumber=" + roomNumber + "&checkIn=" + checkIn + "&checkOut=" + checkOut);
    }
}
