package com.hotelmanagement.dao;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDao {

    // Add a new booking to the database
    public void addBooking(Booking booking) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO bookings (CustomerID, Email, CheckInDate, CheckOutDate, RoomType, RoomView, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, booking.getCustomerId());
            preparedStatement.setString(2, booking.getEmail());
            preparedStatement.setDate(3, new Date(booking.getCheckInDate().getTime()));
            preparedStatement.setDate(4, new Date(booking.getCheckOutDate().getTime()));
            preparedStatement.setString(5, booking.getRoomType());
            preparedStatement.setString(6, booking.getRoomView());
            preparedStatement.setInt(7, booking.getPrice());
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
            throw e;
        }
    }

    // Retrieve a booking by its ID
    public Booking getBookingById(int bookingId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM bookings WHERE BookingID = ?";
        Booking booking = null;
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, bookingId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                booking = new Booking(
                    resultSet.getInt("BookingID"),
                    resultSet.getInt("CustomerID"),
                    resultSet.getString("Email"),
                    resultSet.getDate("CheckInDate"),
                    resultSet.getDate("CheckOutDate"),
                    resultSet.getString("RoomType"),
                    resultSet.getString("RoomView"),
                    resultSet.getInt("Price")
                );
            } else {
                throw new SQLException("Booking not found with ID: " + bookingId);
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
            throw e;
        }

        return booking;
    }
}
