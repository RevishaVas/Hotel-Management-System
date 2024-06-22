package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.model.Parkings;

public class ParkingsDao 
{
	private static final String url = "jdbc:mysql://localhost:3306/usermange";
    private static final String user_name ="root";
    private static final String password = "Goldenhand@008";
    private Connection con;
    private List<Integer> rooms = new ArrayList<>();
    
    
   
    
    public void establish_connection() 
    {
    	try 
    	{
    		if (con==null || con.isClosed())
    		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user_name,password);
    		}
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.getMessage();			
		} 
    	catch (SQLException e) 
    	{	
			e.getMessage();
		}
    }
    
    
    
    
    public Connection get_connection()
    {
    	establish_connection();
    	return con;
    }
    
    
    
    public void close_connection() 
    {
    	try 
    	{
			con.close();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    }
    
    
    public List<Parkings> get_parking_id(Parkings pobj)
    {	
    	System.out.println("Inside parking_id");
    	List<Parkings> ParkingList = new ArrayList<>();
    	if(check_reservation(pobj))
    	{
    		 con=get_connection();
    		 
    		 for(int i=0;i<rooms.size();i++)
    		 {
    			 System.out.println("Inside for loop");
    			 String check_query="select COUNT(*)as count from Parking where RoomNumber = ?;";
    			 String select_query="select RoomNumber,ParkingID,CustomerID from Parking where RoomNumber =? ;";
    			 String update_query="update Parking set RoomNumber = ? ,CustomerID=?,CustomerName=?, status ='Reserved 'where ParkingID =(select ParkingID from (select ParkingID from Parking where status ='Free' order by ParkingID limit 1) as subquery);";
    			 try 
    			 {
    				PreparedStatement ps1 = con.prepareStatement(check_query);
     				ps1.setInt(1,rooms.get(i));
     				
     				ResultSet rs1= ps1.executeQuery();
     				System.out.println("check duplicate query parking already exist");
     				if(rs1.next() && rs1.getInt("count") == 0)
     				{
     						PreparedStatement ps2 = con.prepareStatement(update_query);
     	    				ps2.setInt(1,rooms.get(i));
     	    				ps2.setInt(2,pobj.getCustomerId());
     	    				ps2.setString(3,pobj.getCustomer_name());
     	    				ps2.executeUpdate();
     	    				System.out.println("update query executed");
     				}
     				
     				PreparedStatement ps3 = con.prepareStatement(select_query);
     				ps3.setInt(1, rooms.get(i));
     				ResultSet rs3= ps3.executeQuery();
     				System.out.println("List preparation query executed");
     				while(rs3.next())
     				{
     					int room_number=rs3.getInt("RoomNumber");
     					System.out.println(room_number);
     	                int parkingID = rs3.getInt("ParkingID");
     	                System.out.println(parkingID);
     	                ParkingList.add(new Parkings(parkingID,room_number));
     				}
     				
     				System.out.println(ParkingList);
    			 }
	    		 	catch (SQLException e) 
	    	    	{				
	    				e.printStackTrace();
	    			}
	    	    	
    			 
    		 }
    	}
    	else
    	{
    		pobj.setError_message("No reservation has been made or Customer not yet checkedIn");
    		
    	}
    	
    	try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return ParkingList;
    }
    
    
    public Boolean check_reservation(Parkings pobj) 
    {
    	System.out.println("Inside check_reservation");
    	Boolean result=false;
    	con=get_connection();
    	if(get_customer_details(pobj)) 
    	{
    		String room_select_query = "select RoomNumber from Room where status ='Occupied' and Email = ?;";
        	try 
        	{
    			PreparedStatement ps = con.prepareStatement(room_select_query);
    			System.out.println("Inside get_customerID- after prepare statement "+ps);
    			ps.setString(1,pobj.getEmail());
    			ResultSet rs= ps.executeQuery();
    			System.out.println("Inside check_reservation -- query executed");
    			if(rs.next())
    			{
    				System.out.println("Inside if");
    		      do
    		        {
    			      result=true;
    			      add_room_number(rs.getInt("RoomNumber"));
    		        }while(rs.next());
    		      	System.out.println("Inside if and while completed");
    			}
    			else
    			{
    				result=false;
    			}
    			
    		}
        	
    	
        	catch (SQLException e) 
        	{				
    			e.printStackTrace();
    		}
        	
        	
    	}
    	else
    	{
    		result=false;
    	}
    	
    	System.out.println(result);
    	return result;
	}
    
    
    
    
    
    public Boolean get_customer_details(Parkings pobj) 
    {	
    	System.out.println("Inside get_customerID ");
    	Boolean result=false;
    	String email= pobj.getEmail();
    	con=get_connection();
    	String select_customer = "select CustomerID,FirstName from Customers where Email=?;";
    	
    	try 
    	{
			PreparedStatement ps4 = con.prepareStatement(select_customer);
			ps4.setString(1,email);
			ResultSet rs4 = ps4.executeQuery();
			if(rs4.next())
			{
				result=true;
				pobj.setCustomerId(rs4.getInt("CustomerID"));
				pobj.setCustomer_name(rs4.getString("FirstName"));
			}
    	}
    	catch (SQLException e) 
    	{				
			e.printStackTrace();
		}
    	
    	System.out.println("Exiting get customer id");
    	System.out.println(result);
    	return result;
    }
    
    
    
    
    public void add_room_number(int room_number) 
    {
    	rooms.add(room_number);
    }
     
    
  }

