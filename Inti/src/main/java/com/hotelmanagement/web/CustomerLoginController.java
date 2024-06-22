package com.hotelmanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.dao.CustomerLoginDao;
import com.hotelmanagement.model.LoginBean;

@WebServlet("/customerLogin")
public class CustomerLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerLoginDao customerLoginDao;

    public void init() {
        customerLoginDao = new CustomerLoginDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login/customerLogin.jsp");
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            LoginBean user = customerLoginDao.validate(loginBean);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("customerID",user.getCustomerID()); // Assume you get this from result set
                session.setAttribute("email", user.getUsername());
                session.setAttribute("role", "customer");
                System.out.println(user.getCustomerID()+user.getUsername());

                response.sendRedirect("available"); // Redirect to customer dashboard
            } else {
                request.setAttribute("message", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login/customerLogin.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
