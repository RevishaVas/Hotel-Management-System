package com.hotelmanagement.model;

import java.sql.Date;

public class AvailablityRoom {
	private int bookingId;
	private int RoomNumber;
	private String Status;
	private String roomType;
    private String roomView;
    private Date checkInDate;
    private Date checkOutDate;
    
    
	public AvailablityRoom(int roomNumber) {
		super();
		RoomNumber = roomNumber;
	}

	public AvailablityRoom(int bookingId, int roomNumber, String status, String roomType, String roomView,
			Date checkInDate, Date checkOutDate) {
		super();
		this.bookingId = bookingId;
		RoomNumber = roomNumber;
		Status = status;
		this.roomType = roomType;
		this.roomView = roomView;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
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
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
     

}
