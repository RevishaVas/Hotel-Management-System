package com.hotelmanagement.model;

public class AdminParking {
	private int parking_id;
	private int room_number;
	private String status;
	private String customer_name;
	private int customer_id;
	private int value;
	private String error_message;

	public AdminParking() {

	}

	public AdminParking(int parking_id, int room_number, String status, String customer_name, int customer_id) {
		super();
		this.parking_id = parking_id;
		this.room_number = room_number;
		this.status = status;
		this.customer_name = customer_name;
		this.customer_id = customer_id;
	}

	public int getParking_id() {
		return parking_id;
	}

	public void setParking_id(int parking_id) {
		this.parking_id = parking_id;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}
