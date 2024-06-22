package com.hotelmanagement.web;

import com.hotelmanagement.dao.FeedbackDAO;
import com.hotelmanagement.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/submitFeedback")
public class SubmitFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 

    private FeedbackDAO feedbackDAO;

    @Override
    public void init() {
        feedbackDAO = new FeedbackDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        Feedback feedback = new Feedback(name, email, message);

        try {
            feedbackDAO.addFeedback(feedback);
        } catch (SQLException e) {
            throw new ServletException("Unable to save feedback", e);
        }

        response.sendRedirect("available");
    }
}
