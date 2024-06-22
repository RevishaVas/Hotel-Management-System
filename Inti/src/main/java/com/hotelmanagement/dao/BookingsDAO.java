package com.hotelmanagement.dao;

import com.hotelmanagement.model.Bookings;
import com.hotelmanagement.utils.DBContext;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingsDAO extends DBContext{

    public int addBooking(Bookings booking) {
        int bookingID = 0;
        String sql = "INSERT INTO Bookings (CustomerID, Email, CheckInDate, CheckOutDate, RoomType, RoomView, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, booking.getCustomerID());
            statement.setString(2, booking.getEmail());
            statement.setDate(3, booking.getCheckInDate());
            statement.setDate(4, booking.getCheckOutDate());
            statement.setString(5, booking.getRoomType());
            statement.setString(6, booking.getRoomView());
            statement.setInt(7, booking.getPrice());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                bookingID = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingID;
    }
    
    public int getTotalBookings() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM Bookings";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
