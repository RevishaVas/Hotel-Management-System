package com.hotelmanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.CheckoutDao;
import com.hotelmanagement.dao.ParkingDao;
import com.hotelmanagement.dao.roomDao;
import com.hotelmanagement.model.AvailablityRoom;
import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Room;
@WebServlet("/ProcessCheckout")
public class CheckoutController extends HttpServlet {
    private CheckoutDao checkoutDao;
    private ParkingDao parkingDao;
    private roomDao  RoomDao;
    private BookingDao bookingDAO;

    public void init() {
        checkoutDao = new CheckoutDao(); // Make sure the DAO is initialized appropriately
        this.bookingDAO = new BookingDao();
        RoomDao = new roomDao();
        parkingDao =new ParkingDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the check-in form page
        RequestDispatcher dispatcher = request.getRequestDispatcher("Checkout/Checkout.jsp");
        dispatcher.forward(request, response);
        System.out.println("inside");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookingIdStr = request.getParameter("bookingId");
        LocalDate checkoutDate = LocalDate.parse(request.getParameter("checkoutDate"));
        System.out.println(checkoutDate);

        try {
            int bookingId = Integer.parseInt(bookingIdStr);
            // Update the booking status in the database
            checkoutDao.updateBookingStatusToPaid(bookingId);
            Booking booking = bookingDAO.getBookingById(bookingId);
            Room room = RoomDao.getBookingById(bookingId);
            int RoomNumber =room.getRoomNumber();
            parkingDao.updateParkingStatus(RoomNumber);
            request.setAttribute("bookingId", booking.getBookingId());
            request.setAttribute("customerId", booking.getCustomerId());
            request.setAttribute("email", booking.getEmail());
            request.setAttribute("checkInDate", booking.getCheckInDate());
            request.setAttribute("checkOutDate", booking.getCheckOutDate());
            request.setAttribute("roomType", booking.getRoomType());
            request.setAttribute("roomView", booking.getRoomView());
            request.setAttribute("price", booking.getPrice());
            
            //GetWithBookingId((bookingId), request, response);
            //Booking booking = bookingDAO.getBookingById(bookingId);
            
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Billing/Billing.jsp");
            dispatcher.forward(request, response);
        } 
        
        catch (Exception e) {
            throw new ServletException("Error processing checkout", e);
        }
    }
    
    

}
