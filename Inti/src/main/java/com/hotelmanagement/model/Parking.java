package com.hotelmanagement.model;

public class Parking {
	private int ParkingID;
	private String Status;
	private int CustomerID;
	private int Roomnumber;
	
	public Parking() {}
	
	public Parking(int parkingID, String status, int roomnumber) {
		super();
		this.ParkingID = parkingID;
		this.Status = status;
		this.Roomnumber = roomnumber;
	}
	
	public Parking(int parkingID, String status, int customerID, int roomnumber) {
		super();
		this.ParkingID = parkingID;
		this.Status = status;
		this.CustomerID = customerID;
		this.Roomnumber = roomnumber;
	}
	public int getParkingID() {
		return ParkingID;
	}
	public void setParkingID(int parkingID) {
		ParkingID = parkingID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getRoomnumber() {
		return Roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		Roomnumber = roomnumber;
	}
	
	
	
	

}