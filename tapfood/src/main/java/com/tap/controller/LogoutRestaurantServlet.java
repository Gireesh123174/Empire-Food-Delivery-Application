package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.RestaurantDaoImp;
import com.tap.model.Restaurant;

@WebServlet("/CallServlet2")
public class LogoutRestaurantServlet extends HttpServlet{
	
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	        RestaurantDaoImp r = new RestaurantDaoImp();

	        List<Restaurant> list = r.getAllrestaurant();
	        
	         
	        req.setAttribute("restaurants", list);
	          
	        RequestDispatcher rd = req.getRequestDispatcher("LogoutRestaurant.jsp");
	        rd.forward(req, resp);        
	        
	    }


}
