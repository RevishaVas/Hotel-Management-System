package com.hotelmanagement.model;

public class DynamicPrice 
{
	private String option;
	private int percentage;
	private String roomtype;
	private String roomview;
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getRoomview() {
		return roomview;
	}
	public void setRoomview(String roomview) {
		this.roomview = roomview;
	}

	
	
}