package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.model.AvailablityRoom;
import com.hotelmanagement.utils.JDBCUtils;

public class AvailablityRoomDao {
	
	 public AvailablityRoom getRoomNumberById(int bookingId) throws SQLException, ClassNotFoundException {
	        String sql = "SELECT Roomnumber FROM availabilityrooms WHERE BookingID = ?";
	        AvailablityRoom availablityroom = null;
	        
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setInt(1, bookingId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	availablityroom = new AvailablityRoom(
	                   
	                    resultSet.getInt("RoomNumber")
	                );
	            } else {
	                throw new SQLException("Booking not found with ID: " + bookingId);
	            }
	        } catch (SQLException e) {
	            JDBCUtils.printSQLException(e);
	            throw e;
	        }

	        return availablityroom;
	    }

}
