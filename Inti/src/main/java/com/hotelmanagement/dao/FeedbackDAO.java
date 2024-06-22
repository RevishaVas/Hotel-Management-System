package com.hotelmanagement.dao;

import com.hotelmanagement.model.Feedback;
import com.hotelmanagement.utils.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO extends DBContext{

    public void addFeedback(Feedback feedback) throws SQLException {
    	try {String sql = "INSERT INTO feedback (name, email, message) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, feedback.getName());
                statement.setString(2, feedback.getEmail());
                statement.setString(3, feedback.getMessage());
                int rows = statement.executeUpdate();
                System.out.println(rows);
                
    	}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            } 
        }
    

    public List<Feedback> getAllFeedbacks() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        try 
        {String sql = "SELECT * FROM feedback";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Feedback feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setName(resultSet.getString("name"));
                feedback.setEmail(resultSet.getString("email"));
                feedback.setMessage(resultSet.getString("message"));
                feedback.setCreatedAt(resultSet.getTimestamp("created_at"));
                feedbacks.add(feedback);
			}
        }
        catch (SQLException e) 
        {
			e.printStackTrace();
        
        }
        return feedbacks;
    }    
        
        
}
