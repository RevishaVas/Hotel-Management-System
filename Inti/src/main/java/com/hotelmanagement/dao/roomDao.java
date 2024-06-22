package com.hotelmanagement.dao;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class roomDao {
	
	public void FillRoom(Room room) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO room (BookingID, RoomNumber, Status, RoomType, RoomView, CheckIn, CheckOut,Email) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, room.getBookingId());
            preparedStatement.setInt(2, room.getRoomNumber());
            preparedStatement.setString(3, room.getStatus());
            preparedStatement.setString(4, room.getRoomType());
            preparedStatement.setString(5, room.getRoomView());
            preparedStatement.setDate(6, JDBCUtils.getSQLDate(room.getCheckInDate()));
            preparedStatement.setDate(7, JDBCUtils.getSQLDate(room.getCheckOutDate()));
            preparedStatement.setString(8, room.getEmail());
            //preparedStatement.setInt(9, room.getPrice());
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
            throw e;
        }
    }
	
	public Room getBookingById(int bookingId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Room WHERE BookingID = ? ";
        Room room = null;
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, bookingId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	room = new Room(
                    resultSet.getInt("BookingID"),
                    resultSet.getInt("RoomNumber"),
                    resultSet.getString("Status")
                    
                );
            } else {
                throw new SQLException("Booking not found with ID: " + bookingId);
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
            throw e;
        }

        return room;
    }


	
	
}

