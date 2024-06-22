package com.hotelmanagement.web;

import com.hotelmanagement.dao.RoomAssignmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clear-assignments")
public class ClearAssignmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomAssignmentDAO dao = new RoomAssignmentDAO();
        dao.clearAssignments();

        response.sendRedirect("assign-room");
    }
}
