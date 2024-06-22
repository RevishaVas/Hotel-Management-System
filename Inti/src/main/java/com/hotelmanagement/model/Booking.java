package com.hotelmanagement.model;

import java.sql.Date;

public class Booking {
	private int bookingId;
    private int customerId;
    private String email;
    private Date checkInDate;
    private Date checkOutDate;
    private String roomType;
    private String roomView;
    private int price;
    
	public Booking(int bookingId, int customerId, String email, Date checkInDate, Date checkOutDate, String roomType,
			String roomView, int price) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.email = email;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.roomView = roomView;
		this.price = price;
	}
	
	

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	

}
