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

import com.tap.daoImp.MenuDaoImp;
import com.tap.model.Menu;

 
@WebServlet("/MenuServlet2")
public class MenuServlet2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));

		
		   MenuDaoImp  m   = new MenuDaoImp();
		
	       List<Menu> menu = m.getMenuByRestaurantId(restaurantId);
	       
	       
	       req.setAttribute("menus", menu);
	       
	        RequestDispatcher  rd = req.getRequestDispatcher("displayMenu.jsp");
	        
	        rd.forward(req, resp);
	        
	    
		
	}
  
}
