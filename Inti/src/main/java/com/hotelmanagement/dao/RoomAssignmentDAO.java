package com.hotelmanagement.dao;

import com.hotelmanagement.model.RoomAssignment;
import com.hotelmanagement.utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomAssignmentDAO extends DBContext {

    public void assignRoom(RoomAssignment assignment) {
        String sql = "INSERT INTO RoomAssignments (RoomNumber, EmployeeID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, assignment.getRoomNumber());
            statement.setInt(2, assignment.getEmployeeID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RoomAssignment> getAllAssignments() {
        List<RoomAssignment> assignments = new ArrayList<>();
        String sql = "SELECT * FROM RoomAssignments";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                RoomAssignment assignment = new RoomAssignment();
                assignment.setAssignmentID(resultSet.getInt("AssignmentID"));
                assignment.setRoomNumber(resultSet.getInt("RoomNumber"));
                assignment.setEmployeeID(resultSet.getInt("EmployeeID"));
                assignment.setAssignedTime(resultSet.getTimestamp("AssignedTime"));
                assignments.add(assignment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    public void clearAssignments() {
        String sql = "DELETE FROM RoomAssignments WHERE TIMESTAMPDIFF(MINUTE, AssignedTime, NOW()) >= 20 AND AssignmentID IS NOT NULL";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected); // Debugging line to see if any rows are deleted
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
