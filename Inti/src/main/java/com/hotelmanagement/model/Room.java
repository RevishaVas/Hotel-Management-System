package com.hotelmanagement.model;

import java.sql.Date;
import java.time.LocalDate;

public class Room {
	private int bookingId;
    private int RoomNumber;
    private String status;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomType;
    private String roomView;
    private int price;
    private String Email;
    
    


	public Room(int bookingId, int roomNumber, String status) {
		super();
		this.bookingId = bookingId;
		RoomNumber = roomNumber;
		this.status = status;
	}



	public Room(int bookingId, int roomNumber, String status, LocalDate checkInDate, LocalDate checkOutDate, String roomType,
			String roomView, int price, String email) {
		super();
		this.bookingId = bookingId;
		this.RoomNumber = roomNumber;
		this.status = status;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.roomView = roomView;
		this.price = price;
		Email = email;
	}
	


	public Room() {
		
	}

	public Room(int bookingId, int roomNumber, String status, String roomType, String roomView, LocalDate checkInDate, LocalDate checkOutDate,
			String email) {
		super();
		this.bookingId = bookingId;
		this.RoomNumber = roomNumber;
		this.status = status;
		this.roomType = roomType;
		this.roomView = roomView;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.Email = email;
		// TODO Auto-generated constructor stub
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
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
