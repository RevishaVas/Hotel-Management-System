package com.hotelmanagement.dao;

import com.hotelmanagement.model.AvailabilityRoom;
import com.hotelmanagement.utils.DBContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvailabilityRoomDAO extends DBContext {

    public boolean isRoomAvailable(AvailabilityRoom availabilityRoom) {
        String sql = "SELECT COUNT(*) FROM AvailabilityRooms WHERE RoomNumber = ? AND RoomType = ? AND RoomView = ? AND CheckIn = ? AND CheckOut = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, availabilityRoom.getRoomNumber());
            statement.setString(2, availabilityRoom.getRoomType());
            statement.setString(3, availabilityRoom.getRoomView());
            statement.setDate(4, availabilityRoom.getCheckIn());
            statement.setDate(5, availabilityRoom.getCheckOut());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void insertAvailabilityRoom(AvailabilityRoom availabilityRoom) {
        String sql = "INSERT INTO AvailabilityRooms (RoomNumber, RoomType, RoomView, CheckIn, CheckOut, BookingID, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, availabilityRoom.getRoomNumber());
            statement.setString(2, availabilityRoom.getRoomType());
            statement.setString(3, availabilityRoom.getRoomView());
            statement.setDate(4, availabilityRoom.getCheckIn());
            statement.setDate(5, availabilityRoom.getCheckOut());
            statement.setInt(6, availabilityRoom.getBookingId());
            statement.setString(7, availabilityRoom.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAvailabilityRoom(AvailabilityRoom availabilityRoom) {
        String sql = "UPDATE AvailabilityRooms SET BookingID = ?, Status = ?, CheckIn = ?, CheckOut = ? WHERE RoomNumber = ? AND RoomType = ? AND RoomView = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, availabilityRoom.getBookingId());
            statement.setString(2, availabilityRoom.getStatus());
            statement.setDate(3, availabilityRoom.getCheckIn());
            statement.setDate(4, availabilityRoom.getCheckOut());
            statement.setInt(5, availabilityRoom.getRoomNumber());
            statement.setString(6, availabilityRoom.getRoomType());
            statement.setString(7, availabilityRoom.getRoomView());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
