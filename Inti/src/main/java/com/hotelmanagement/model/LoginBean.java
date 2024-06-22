package com.hotelmanagement.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;
	private int CustomerID;
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
}
