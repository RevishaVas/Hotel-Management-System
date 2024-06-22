package com.hotelmanagement.web;

import com.hotelmanagement.dao.RoomAssignmentDAO;
import com.hotelmanagement.dao.EmployeeDao;
import com.hotelmanagement.dao.EmployeeDaoImpl;
import com.hotelmanagement.dao.RoomsDAO;
import com.hotelmanagement.model.Employee;
import com.hotelmanagement.model.Rooms;
import com.hotelmanagement.model.RoomAssignment;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/assign-room")
public class AssignRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDaoImpl();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomsDAO roomDAO = new RoomsDAO();
        RoomAssignmentDAO assignmentDAO = new RoomAssignmentDAO();

        List<Employee> listEmployee = employeeDAO.selectAllEmployees();
        List<Rooms> rooms = roomDAO.getRoomsByStatus();
        List<RoomAssignment> assignments = assignmentDAO.getAllAssignments();

        request.setAttribute("employees", listEmployee);
        request.setAttribute("rooms", rooms);
        request.setAttribute("assignments", assignments);

        request.getRequestDispatcher("/assign-room.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));

        RoomAssignment assignment = new RoomAssignment();
        assignment.setRoomNumber(roomNumber);
        assignment.setEmployeeID(employeeID);

        RoomAssignmentDAO dao = new RoomAssignmentDAO();
        dao.assignRoom(assignment);

        response.sendRedirect("assign-room");
    }
}
