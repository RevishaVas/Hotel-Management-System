package com.hotelmanagement.dao;

import com.hotelmanagement.model.UserEdit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hotelmanagement.utils.DBContext;

public class UserEditDAO extends DBContext {

	public void updateUser(UserEdit userEdit) throws SQLException {
		String sql = "UPDATE customers SET firstname =?, lastname =?, email =?, address =?, phoneNumber =? WHERE customerId =?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userEdit.getFirstName());
			statement.setString(2, userEdit.getLastName());
			statement.setString(3, userEdit.getEmail());
			statement.setString(4, userEdit.getAddress());
			statement.setString(5, userEdit.getPhoneNumber());
			statement.setInt(6, userEdit.getCustomerId());
			System.out.println(statement + "Prepared statement"+ userEdit.getFirstName());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} 

	}
	
//	public UserEdit getCustomerByID(int  CustomerID) throws SQLException {
//		String sql = "SELECT * FROM customers WHERE id =?";
//		UserEdit user = null;
//		try {
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, CustomerID);
//			 ResultSet resultSet = statement.executeUpdate();
//			 if (resultSet.next()) {
//				 user = new UserEdit(
//	                    resultSet.getInt("CustomerID"),
//	                    resultSet.getString("Email"),
//	                    resultSet.getDate("CheckInDate"),
//	                    resultSet.getDate("CheckOutDate"),
//	                    resultSet.getString("RoomType"),
//	                    resultSet.getString("RoomView"),
//	                    resultSet.getInt("Price")
//	                );
//	            } else {
//	                throw new SQLException("Booking not found with ID: " + bookingId);
//	            }
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//
//		} 
//
//	}
	
}