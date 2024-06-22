package com.hotelmanagement.model;

public class Parkings 
{
private int CustomerId;
private int parkingID;
private int	room_number;
private String error_message;
private String email;
private String Customer_name;
public Parkings()
{
	
}

public Parkings(int parkingID, int room_number) {
	super();
	this.parkingID = parkingID;
	this.room_number = room_number;
}


public int getCustomerId() {
	return CustomerId;
}

public void setCustomerId(int customerId) {
	CustomerId = customerId;
}

public String getError_message() {
	return error_message;
}

public void setError_message(String error_message) {
	this.error_message = error_message;
}

public int getParkingID() {
	return parkingID;
}

public void setParkingID(int parkingID) {
	this.parkingID = parkingID;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getRoom_number() {
	return room_number;
}

public void setRoom_number(int room_number) {
	this.room_number = room_number;
}

public String getCustomer_name() {
	return Customer_name;
}

public void setCustomer_name(String customer_name) {
	Customer_name = customer_name;
}

}
