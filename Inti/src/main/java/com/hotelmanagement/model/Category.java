package com.hotelmanagement.model;

public class Category {
    
    private int categoryID;
    private String roomType;
    private String roomView;
    private int price;


    public Category(String roomType, String roomView) {
		super();
		this.roomType = roomType;
		this.roomView = roomView;
	}

	public Category(String roomType, String roomView, int price) {
		super();
		this.roomType = roomType;
		this.roomView = roomView;
		this.price = price;
	}

	public Category() {
    }

    public Category(int categoryID, String roomType, String roomView, int price) {
        this.categoryID = categoryID;
        this.roomType = roomType;
        this.roomView = roomView;
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", roomType='" + roomType + '\'' +
                ", roomView='" + roomView + '\'' +
                ", price=" + price +
                '}';
    }
}
