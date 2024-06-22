package com.hotelmanagement.model;

import java.sql.Timestamp;

public class RoomAssignment {
    private int assignmentID;
    private int roomNumber;
    private int employeeID;
    private Timestamp assignedTime;
    
	public int getAssignmentID() {
		return assignmentID;
	}
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Timestamp getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(Timestamp assignedTime) {
		this.assignedTime = assignedTime;
	}

    
}
