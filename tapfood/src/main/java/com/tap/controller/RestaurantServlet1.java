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
import com.tap.daoImp.UserDaoImp;
import com.tap.model.Restaurant;

@WebServlet("/LoginServlet")

public class RestaurantServlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	String username=(String)session.getAttribute("username");
    	UserDaoImp userDao = new UserDaoImp();
      int userId = userDao.getUserIdByUsername(username);
    	
        RestaurantDaoImp r = new RestaurantDaoImp();

        List<Restaurant> list = r.getAllrestaurant();
        
            
            
            String name=  (String) session.getAttribute("username");
           
            req.setAttribute("restaurants", list);
            
            session.setAttribute("userId", userId);
            
            req.setAttribute("username", name);
            
        RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
        rd.forward(req, resp);        
        
    }

}
 