package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.model.LoginBean;
import com.hotelmanagement.utils.JDBCUtils;

public class CustomerLoginDao {

    public LoginBean validate(LoginBean loginBean) throws ClassNotFoundException {
        LoginBean user = null;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM usermange.customers WHERE email = ? and password = ?")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new LoginBean();
                user.setUsername(rs.getString("email")); // Assuming email is used as username
                user.setPassword(rs.getString("password"));
                user.setCustomerID(rs.getInt("CustomerID"));
                user.setrole("customer"); // Assuming role handling if needed
                // Set additional attributes as needed
            }

        } catch (SQLException e) {
            // Process SQL Exception
            JDBCUtils.printSQLException(e);
        }
        return user;
    }
}
