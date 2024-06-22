package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.model.LoginBean;
import com.hotelmanagement.utils.JDBCUtils;

public class LoginDao {

    public String validate(LoginBean loginBean) throws ClassNotFoundException {
        String role = null;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select role from users where username = ? and password = ?")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
                System.out.println(rs.getString("role"));
                
                
            }

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return role;
    }
}
