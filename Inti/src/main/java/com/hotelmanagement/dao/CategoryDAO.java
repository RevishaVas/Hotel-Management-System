package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.model.Category;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.utils.DBContext;
import com.hotelmanagement.utils.JDBCUtils;

public class CategoryDAO extends DBContext {

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT DISTINCT RoomType, RoomView, Price FROM Categories";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Category category = new Category();
//                System.out.println(resultSet.getString("RoomType"));
//                System.out.println(resultSet.getString("RoomView"));
//                System.out.println(resultSet.getInt("Price"));
                category.setRoomType(resultSet.getString("RoomType"));
                category.setRoomView(resultSet.getString("RoomView"));
                category.setPrice(resultSet.getInt("Price"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    
    public Category getByTypeCategories(String roomType,String roomView) {
    	Category category = null;
        String sql = "SELECT DISTINCT RoomType, RoomView, Price FROM Categories WHERE RoomType = ? AND RoomView = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	
        	statement.setString(1, roomType);
        	statement.setString(2, roomView);
            	 ResultSet resultSet = statement.executeQuery();
				
            	 while (resultSet.next()) {
            		 category = new Category(
            				resultSet.getString("RoomType"), 
            				resultSet.getString("RoomView"),
            				resultSet.getInt("Price")
            				 );
                 }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;
    }
    
  
}
