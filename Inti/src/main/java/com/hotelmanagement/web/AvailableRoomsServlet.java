package com.hotelmanagement.web;

import com.hotelmanagement.dao.RoomsDAO;
import com.hotelmanagement.model.Rooms;

import com.hotelmanagement.dao.CategoryDAO;
import com.hotelmanagement.model.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@WebServlet("/available")
public class AvailableRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Rooms firstRoom;
	private Rooms availableRoom = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAllCategories();

		request.setAttribute("categories", categories);
		request.getRequestDispatcher("booking/room-search.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String roomType = request.getParameter("roomType");
		String roomView = request.getParameter("roomView");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");

		Date checkInDate = null;
		Date checkOutDate = null;

		try {
			if (checkIn != null && !checkIn.isEmpty()) {
				checkInDate = Date.valueOf(checkIn);
			}
			if (checkOut != null && !checkOut.isEmpty()) {
				checkOutDate = Date.valueOf(checkOut);
			}
		} catch (IllegalArgumentException e) {
			request.setAttribute("error", "Invalid date format. Please use YYYY-MM-DD.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

		if (checkInDate == null || checkOutDate == null) {
			request.setAttribute("error", "Check-in and Check-out dates are required.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}

		RoomsDAO roomDAO = new RoomsDAO();
		List<Rooms> availableRooms = roomDAO.getAvailableRooms(roomType, roomView, checkInDate, checkOutDate);

		// remove afterwards
		for (Rooms room : availableRooms) {
			System.out.println(room + "availableRooms");
		}

		Map<Integer, Rooms> roomMap = new HashMap<>();

		for (Rooms room : availableRooms) {
			Date roomCheckIn = room.getCheckIn();
			Date roomCheckOut = room.getCheckOut();

			// Check if checkIn and checkOut are not null before comparing
			if (roomCheckIn != null && roomCheckOut != null) {
				boolean isOverlapping = !(checkOutDate.before(roomCheckIn) || checkInDate.after(roomCheckOut));
				if (isOverlapping) {
					// dates overlap
					if ("Booked".equals(room.getStatus())) {
						roomMap.put(room.getRoomNumber(), room);
					}
				} else {
					// do not overlap
					roomMap.putIfAbsent(room.getRoomNumber(), room);
				}
			} else {
				// dates are null
				roomMap.putIfAbsent(room.getRoomNumber(), room);
			}
		}

		List<Rooms> filteredRooms = new ArrayList<>(roomMap.values());

		if (!filteredRooms.isEmpty()) {
			firstRoom = filteredRooms.get(0); // Get the first room if list is not empty
		}
		// Print the filteredRooms remove afterwards
		for (Rooms room : filteredRooms) {
			System.out.println(room);
		}
		
		for (Rooms room : filteredRooms) {
		    if ("Available".equals(room.getStatus()) && session.getAttribute("role") == "customer") {
		        availableRoom = room;  // Assign the room to availableRoom if it matches the condition
		        break;  // Break the loop once a match is found
		    }
		}
		request.setAttribute("availableRooms", filteredRooms);
		request.setAttribute("firstAvailableRooms", availableRoom);
		request.setAttribute("checkInDate", checkInDate);
		request.setAttribute("checkOutDate", checkOutDate);
		System.out.println(firstRoom + "firstRoom");
		System.out.println(session.getAttribute("role")+"request.getAttribute(\"role\")");
		if (session.getAttribute("role") == "customer") {
			request.getRequestDispatcher("booking/customerBooking.jsp").forward(request, response);
		} else if (session.getAttribute("role") == null || session.getAttribute("role") == "admin") {
			request.getRequestDispatcher("available-rooms.jsp").forward(request, response);
		}
	}
}
