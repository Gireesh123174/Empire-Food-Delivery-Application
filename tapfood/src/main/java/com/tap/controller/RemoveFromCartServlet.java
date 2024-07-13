package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartCreator;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the item ID parameter from the request as String
        String menuIdString = request.getParameter("menuId");
        
        // Convert the menuIdString to int
        int menuId = Integer.parseInt(menuIdString);

        // Retrieve the cart from the session
        HttpSession session = request.getSession();
        CartCreator cart = (CartCreator) session.getAttribute("cartCreator");

        if (cart != null) {
            // Remove the item from the cart based on the item ID (now as int)
            cart.deleteCartItem(menuId);

            // Update the cart in the session
            session.setAttribute("cartCreator", cart);
        }

        // Redirect back to the cart page
        response.sendRedirect("cart.jsp");
    }
}
