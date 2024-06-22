package com.hotelmanagement.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hotelmanagement.dao.LoginDao;
import com.hotelmanagement.model.LoginBean;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            String userRole = loginDao.validate(loginBean);

            if (userRole != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                session.setAttribute("role", userRole);

                if ("admin".equals(userRole)) {
                    response.sendRedirect("todo/employee-list.jsp"); // Redirect to admin dashboard
                } else if ("customer".equals(userRole)) {
                    response.sendRedirect("checkin/sucess.jsp"); // Redirect to customer homepage
                }
            } else {
                request.setAttribute("message", "Invalid username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
