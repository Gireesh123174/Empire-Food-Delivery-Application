package com.tap.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.model.CartCreator;


@WebServlet("/UpdateQuantityServlet")
public class UpdateQuantityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        int menuId =Integer.parseInt(request.getParameter("menuId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Get the cart from the session
        CartCreator cart = (CartCreator) request.getSession().getAttribute("cartCreator");

        // Update the quantity of the item in the cart
        if (cart != null) {
        	
        	cart.updateCartItem(menuId, quantity);
          
        // Redirect back to the cart page
        response.sendRedirect("cart.jsp");
    }
}

}