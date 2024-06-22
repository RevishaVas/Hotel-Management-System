package com.hotelmanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hotelmanagement.dao.UpdatePriceDao;
import com.hotelmanagement.model.DynamicPrice;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PriceForm")
/**
 * Servlet implementation class PriceFormServlet
 */
public class PriceFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("price/Price.jsp");
        rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UpdatePriceDao updobj=new UpdatePriceDao();
			DynamicPrice dpobj= new DynamicPrice();
			
			String choice =request.getParameter("action");
			String roomtype = request.getParameter("roomtype");
			String roomview = request.getParameter("roomview");
			
			
			if("Get Price".equals(choice))
			{
				dpobj.setRoomtype(roomtype);
				dpobj.setRoomview(roomview);
				try {
					int current_price=updobj.get_room_price(dpobj);
					request.setAttribute("current_price",current_price );
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			else
			{
				
			String option = request.getParameter("opt");
			int percentage= Integer.parseInt(request.getParameter("per"));
			dpobj.setOption(option);
			dpobj.setPercentage(percentage);
			dpobj.setRoomtype(roomtype);
			dpobj.setRoomview(roomview);

				try {
					int updated_price=updobj.update_price(dpobj);
					request.setAttribute("result", "Price Successfully Updated");
					request.setAttribute("updated_price", updated_price);
					
				} catch (ClassNotFoundException e) {
					e.getMessage();
				}			
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("price/Price.jsp");
			rd.forward(request, response);     	
	
			
	}
	
	
}