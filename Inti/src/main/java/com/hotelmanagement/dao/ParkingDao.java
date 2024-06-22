package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hotelmanagement.utils.JDBCUtils;
import com.hotelmanagement.model.Parking;
import com.hotelmanagement.model.Room;

public class ParkingDao {
    private static final String UPDATE_PARKING = "UPDATE parking SET status = 'Free',  WHERE RoomNumber= ?;";

    private Connection connection;

    // Constructor to initialize the ParkingDao with a database connection
    public ParkingDao() {
        this.connection = JDBCUtils.getConnection();
    }

    // Method to update parking status and room number
    public void updateParkingStatus(int bookingId) throws SQLException {
        String sql = "UPDATE parking SET status = 'Free' WHERE Roomnumber = ?";
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