package com.hotelmanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmPayment")
public class PaymentServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simply forward the request to the JSP page to render the payment form
        request.getRequestDispatcher("Billing/confirmPayment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve payment details from the request
        String bookingId = request.getParameter("bookingId");
        String paymentAmount = request.getParameter("paymentAmount");

        try {
            // Validate payment information
            if (bookingId == null || paymentAmount == null) {
                throw new IllegalArgumentException("Missing required parameters.");
            }

            // Process the payment
            boolean paymentConfirmed = processPayment(bookingId, paymentAmount);

            // Set attributes for the JSP page
            request.setAttribute("paymentConfirmed", paymentConfirmed);
            request.setAttribute("bookingId", bookingId);

            // Forward to JSP page
            request.getRequestDispatcher("confirmPayment.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle any errors
            request.setAttribute("errorMessage", "Error processing payment: " + e.getMessage());
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private boolean processPayment(String bookingId, String paymentAmount) {
        // Logic to process payment
        // This is a stub, replace with real payment processing logic
        return true; // Assuming the payment is always successful
    }
}
