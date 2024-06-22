package com.hotelmanagement.model;

import java.sql.Date;

public class Rooms {
    private int id;
    private int bookingId;
    private int roomNumber;
    private String status;
    private String roomType;
    private String roomView;
    private Date checkIn;
    private Date checkOut;
    private String email;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomView() {
		return roomView;
	}
	public void setRoomView(String roomView) {
		this.roomView = roomView;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	 @Override
	    public String toString() {
	        return "Room{" +
	               "roomNumber=" + roomNumber +
	               ", roomType='" + roomType + '\'' +
	               ", roomView='" + roomView + '\'' +
	               ", status='" + status + '\'' +
	               ", checkIn=" + checkIn +
	               ", checkOut=" + checkOut +
	               '}';
	    }
}
