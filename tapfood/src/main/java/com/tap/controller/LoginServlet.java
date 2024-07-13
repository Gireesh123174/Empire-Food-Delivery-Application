package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.UserDaoImp;


@WebServlet("/Restaurant")
public class LoginServlet extends HttpServlet {
	

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	UserDaoImp  user = new UserDaoImp();
      
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
        HttpSession session = request.getSession();  
        
        Integer attempts = (Integer) session.getAttribute("attempts");
        
        if (attempts == null) {
            attempts = 0;
        }
        
        int maxAttempts = 3;
        int attemptsLeft = maxAttempts - attempts;
        
        
        if (attempts >= maxAttempts)
        {
        	// If the user has already made three wrong attempts, display a message to contact admin
        	request.setAttribute("error", "Contact administrator");
        	request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }
        
        if (user.authenticateUser(username, password)) {
        	
        	session.setAttribute("attempts", 0);
        	session.setAttribute("username", username);
            response.sendRedirect("RestaurantServlet");   
        } 
        else 
        {
        	 attempts++;
        	 session.setAttribute("attempts", attempts);
        	  String errorMsg = "Invalid username or password. " + attemptsLeft + " attempt(s) left.";
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

   
}
