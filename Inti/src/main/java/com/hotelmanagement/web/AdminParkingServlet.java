package com.hotelmanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hotelmanagement.dao.AdminParkingDao;
import com.hotelmanagement.model.AdminParking;


import java.io.IOException;
import java.util.List;

@WebServlet("/AdminParking")
/**
 * Servlet implementation class AdminParkingServlet
 */
public class AdminParkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminParkingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("parking/AdminParkingForm.jsp");
        rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String option =request.getParameter("option");
		String searchValue =request.getParameter("searchValue");
		
		int value;
		if(option.equals("search"))
		{
			value=Integer.parseInt(searchValue);
		}
		else
		{
			value=0;
		}
		
		
		AdminParking apobj=new AdminParking();
		apobj.setValue(value);
		AdminParkingDao apdobj= new AdminParkingDao();
		List<AdminParking> parking_details=apdobj.get_parking_details(apobj);
		request.setAttribute("parking_details", parking_details);
		request.setAttribute("error_message", apobj.getError_message());
		RequestDispatcher rd = request.getRequestDispatcher("parking/AdminParking.jsp");
		rd.forward(request, response);
		
		
	}

}
	

