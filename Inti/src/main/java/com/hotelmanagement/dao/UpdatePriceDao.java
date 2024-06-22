package com.hotelmanagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.model.DynamicPrice;
import com.hotelmanagement.utils.DBContext;

public class UpdatePriceDao extends DBContext {
	
	    int new_price;
	    int current_price;
	    

	    public int update_price(DynamicPrice dpobj) throws ClassNotFoundException
	    {
	    	
	    	String update_query= "update categories set Price=? where RoomType=? and RoomView=?;";
	    	
	    	try 
	    	{			
					current_price=get_room_price(dpobj);
					
					if((dpobj.getOption()).equals("increase"))
					{
						
						new_price = current_price +((current_price * dpobj.getPercentage())/100);
					}
					else
					{	
						System.out.println("inside else");
						new_price = current_price -((current_price * dpobj.getPercentage())/100);
					}
					
					PreparedStatement ps2 = connection.prepareStatement(update_query);
					ps2.setInt(1,new_price);
					ps2.setString(2,dpobj.getRoomtype());
					ps2.setString(3,dpobj.getRoomview());
					int rows= ps2.executeUpdate();

					/* connection.close(); */
					
				}				
			 
	    	catch (SQLException e) 
	    	{				
				e.printStackTrace();
			}
	    	return new_price;
	    	
	    }
	    
	    
	    public int get_room_price(DynamicPrice dpobj)throws ClassNotFoundException
	    {
	    	String select_query= "select Price from Categories where RoomType=? and RoomView=?;";
	    	    	
	    	try 
	    	{
				PreparedStatement ps1 = connection.prepareStatement(select_query);
				ps1.setString(1,dpobj.getRoomtype());
				ps1.setString(2,dpobj.getRoomview());
				ResultSet rs= ps1.executeQuery();
				
				while(rs.next())
				{	
					current_price=rs.getInt("price");
					System.out.println(current_price);
				}
							
	    	}
	    	catch (SQLException e) 
	    	{				
				e.printStackTrace();
			}
	    
	    
	    	return current_price;
	       
	    }	    
}