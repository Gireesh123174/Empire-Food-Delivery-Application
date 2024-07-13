package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.UserDaoImp;
import com.tap.model.CartCreator;
import com.tap.model.CartItem;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	UserDaoImp userDao = new UserDaoImp();

    
        String name = req.getParameter("name");
        String imagepath = req.getParameter("imagePath"); 
        int price =Integer.parseInt(req.getParameter("price"));
        int menuid = Integer.parseInt(req.getParameter("menuId"));
        int restaurantId= Integer.parseInt(req.getParameter("restaurantId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        
        CartItem c = new CartItem(menuid,restaurantId,name,imagepath,price,quantity);
        
        HttpSession session = req.getSession();
    	String username=(String)session.getAttribute("username");
    	int userId = userDao.getUserIdByUsername(username);
    	
    	
        
        
        CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");
        
        
        if(cartCreator == null)
        {
        	cartCreator = new CartCreator();
        	
        }

//            HttpSession session = req.getSession();
            cartCreator.addCartItem(c);
            session.setAttribute("cartCreator", cartCreator);
            session.setAttribute("restaurantId", restaurantId);
            
            session.setAttribute("userId", userId);
           
            session.setAttribute("menuid", menuid);
                     
          RequestDispatcher rd  = req.getRequestDispatcher("cart.jsp");
            rd.forward(req, resp);
            
        
          
        
    }
}
