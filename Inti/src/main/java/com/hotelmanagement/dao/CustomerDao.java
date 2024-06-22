package com.hotelmanagement.dao;

import com.hotelmanagement.model.Customer;
import com.hotelmanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {

    // Add a new customer to the database
    public int addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
    	int customerID  = 0;
    	 System.out.println(" hit here pramuk");
        String sql = "INSERT INTO customers (firstname, lastname, email, phonenumber, address) VALUES (?, ?, ?, ?, ?)";
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection+ "data hit here");
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            System.out.println(customer.getFirstName()+ "data hit here");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getAddress());
            int rows = preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
            	customerID = generatedKeys.getInt(1);
            }
            
            System.out.println(rows + "rows pramukh" + preparedStatement);
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
            throw e;
        }
        return customerID;
    }

    // Retrieve a customer by their ID
    public Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        Customer customer = null;
        
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(
                    resultSet.getInt("customer_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address")
                );
            } else {
                throw new SQLException("Customer not found with ID: " + customerId);
            }
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
            throw e;
        }

        return customer;
    }
    
    public int getTotalCustomers() {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM Customers";
        Connection connection = JDBCUtils.getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Total Customers: " + total); 
        return total;
    }
}
