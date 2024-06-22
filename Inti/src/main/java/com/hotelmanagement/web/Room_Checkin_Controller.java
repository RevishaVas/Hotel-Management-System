package com.hotelmanagement.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.hotelmanagement.dao.AvailablityRoomDao;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.CustomerDao;
import com.hotelmanagement.dao.roomDao;
import com.hotelmanagement.model.AvailablityRoom;
import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.model.Room;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/room_checkin")
public class Room_Checkin_Controller extends HttpServlet{
	
	private roomDao RoomDAO;
	private AvailablityRoomDao availablityRoomDao;

	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize your DAO here
        this.RoomDAO = new roomDao();
        this.availablityRoomDao=new AvailablityRoomDao();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		walkInCheckIn(request, response);
		
		
	}
	
	 private void walkInCheckIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		 	
	        // Extract and handle walk-in guest data
		 	int Bookingid = Integer.parseInt(request.getParameter("bookingId"));
		 	int Customerid = Integer.parseInt(request.getParameter("customerId"));
	        String lastName = request.getParameter("lastName");
	        String Email = request.getParameter("email");
	        String phone = request.getParameter("phoneNumber");
	        String address = request.getParameter("address");
	        LocalDate checkInDate = LocalDate.parse(request.getParameter("checkInDate"));
	        LocalDate checkOutDate = LocalDate.parse(request.getParameter("checkOutDate"));
	        String roomType = request.getParameter("roomType");
	        String roomView = request.getParameter("roomView");
	        int price = Integer.parseInt(request.getParameter("price"));
	        String occupied="Occupied";
	        
	        
	        int Roomnumber=0;
	        try {
	        	AvailablityRoom availablityRoom = availablityRoomDao.getRoomNumberById(Bookingid);
	        	 System.out.println(availablityRoom.getRoomNumber());
	        	 Roomnumber=availablityRoom.getRoomNumber();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        //System.out.println(Roomnumber);
	        Room room = new Room(Bookingid,Roomnumber,occupied,checkInDate,checkOutDate,roomType,roomView,price,Email);
	        
	        System.out.println("Deatils Here"+Bookingid+11+ occupied+checkInDate+checkOutDate+roomType+roomView+price+Email);
	        

	        
	        try {
	        	RoomDAO.FillRoom(room);
	            response.sendRedirect("checkin/sucess.jsp"); // Redirect to a success page if the operation is successful
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            System.out.println("execption here");
	            response.sendRedirect("checkin/error.jsp");
	        }
	    }
	
	
}
