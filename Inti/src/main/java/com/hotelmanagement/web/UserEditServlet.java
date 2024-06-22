package com.hotelmanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hotelmanagement.dao.UserEditDAO;
import com.hotelmanagement.model.UserEdit;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;


@WebServlet("/user-update")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserEditDAO userEditDAO;
       
	public void init() {
		userEditDAO = new UserEditDAO();
	}
    public UserEditServlet() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("firstname") + "hit update here");
		HttpSession session = request.getSession();
		int customerID = (int) session.getAttribute("customerID");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		System.out.println(firstname+ lastname+ email+ phone+ address+"test attributes");
		UserEdit book = new UserEdit(customerID, firstname, lastname, email, phone, address);
		
		try {
			userEditDAO.updateUser(book);
        } catch (SQLException e) {
            throw new ServletException("Unable to save feedback", e);
        }
		response.sendRedirect("available");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerID = (int) session.getAttribute("customerID");
		String email = (String) session.getAttribute("email");
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("userId",customerID);
        request.setAttribute("email",email);
        dispatcher.forward(request, response);
    }
	}

