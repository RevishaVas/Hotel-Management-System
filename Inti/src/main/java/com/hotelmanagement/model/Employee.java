package com.hotelmanagement.model;

public class Employee {
    private long id;
    private String firstName;
    private String role;
    private String shift;
    private boolean status;

    public Employee(String firstName, String role, String shift, boolean status) {
		super();
		this.firstName = firstName;
		this.role = role;
		this.shift = shift;
		this.status = status;
	}

	public Employee(long id, String firstName, String role, String shift, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.role = role;
        this.shift = shift;
        this.status = status;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}