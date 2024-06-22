package com.hotelmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.model.AdminParking;
import com.hotelmanagement.utils.DBContext;

public class AdminParkingDao extends DBContext{
    
    public List<AdminParking> get_parking_details(AdminParking apobj)
    {	
    	List<AdminParking> parking_details = new ArrayList<>();
    	
    	String select_query="select * from Parking;";
    	String select_query_2="select * from Parking where RoomNumber=?;";

    	try
    	{
    		PreparedStatement ps;
    		if(apobj.getValue()==0)
    		{
    			ps = connection.prepareStatement(select_query);
    		}
    		else
    		{
    			ps = connection.prepareStatement(select_query_2);
    			ps.setInt(1, apobj.getValue());
    		}
    		ResultSet rs = ps.executeQuery();
    		if(rs.next())
    		{
    			do
    				{
    				int parking_id=rs.getInt("ParkingID");
    				int room_number=rs.getInt("RoomNumber");
        			String status = rs.getString("Status");
        			String customer_name=rs.getString("CustomerName");
        			int customer_id=rs.getInt("CustomerID");
        			parking_details.add(new AdminParking(parking_id,room_number,status,customer_name,customer_id));   
    				}while(rs.next());   			 			
    		}
    		else
    		{
    			apobj.setError_message("No parking Slot assigned for this room number");
    		}
    	}
    	
    	catch (SQLException e) 
    	{				
			e.printStackTrace();
		}
    	return parking_details;	
    }
    
}