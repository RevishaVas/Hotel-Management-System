package com.hotelmanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hotelmanagement.dao.ParkingsDao;
import com.hotelmanagement.model.Parkings;

import java.io.IOException;
import java.util.List;

@WebServlet("/ParkingForm")
/**
 * Servlet implementation class ParkingFormServlet
 */
public class ParkingFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hit here");
		RequestDispatcher rd = request.getRequestDispatcher("customerParking.jsp");
        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		
		Parkings pobj= new Parkings();
		pobj.setEmail(email);		
		ParkingsDao pdobj = new ParkingsDao();
		List<Parkings> parking_list=pdobj.get_parking_id(pobj);
		request.setAttribute("parkingList", parking_list);
	    request.setAttribute("errorMessage", pobj.getError_message());
	    request.setAttribute("customer_name",pobj.getCustomer_name());
	    request.setAttribute("customer_id", pobj.getCustomerId());
	    RequestDispatcher rd = request.getRequestDispatcher("Parkingdetails.jsp");
	    rd.forward(request, response);
		
	}

}	
