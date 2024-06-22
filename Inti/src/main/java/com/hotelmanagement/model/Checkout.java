package com.hotelmanagement.model;

import java.util.Date;

public class Checkout {
    private int bookingId;
    private String status;
    private Date checkoutDate;

    // Constructor
    public Checkout(int bookingId, String status, Date checkoutDate) {
        this.bookingId = bookingId;
        this.status = status;
        this.checkoutDate = checkoutDate;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
