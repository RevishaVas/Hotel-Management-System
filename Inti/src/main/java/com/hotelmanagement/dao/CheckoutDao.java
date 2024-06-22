package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hotelmanagement.utils.JDBCUtils;

public class CheckoutDao {
	public void updateBookingStatusToPaid(int bookingId) throws SQLException {
        String sql = "UPDATE room SET status = 'Paid' WHERE BookingID = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bookingId);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No booking found with ID: " + bookingId);
            }
        } catch (SQLException e) {
            throw new SQLException("Error updating booking status: " + e.getMessage(), e);
        }
    }

}