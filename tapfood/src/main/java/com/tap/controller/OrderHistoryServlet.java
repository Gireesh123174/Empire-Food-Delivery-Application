package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.OrderItemsDaoImp;
import com.tap.model.OrderItems;


@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
        int userId = (int)session.getAttribute("userId");
		
        OrderItemsDaoImp daoI = new OrderItemsDaoImp();
		List<OrderItems> orderitem = daoI.getOrderItemByHistoryId(userId);
		session.setAttribute("orderitem", orderitem);
		
		resp.sendRedirect("HistoryDetails.jsp");
		
		
	}

}


//public class historyDetails extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int historyId = Integer.parseInt(req.getParameter("historyId"));
//		
//		OrderItemDaoI daoI = new OrderItemDaoI();
//		List<Orderitem> orderitem = daoI.getOrderItemByHistoryId(historyId);
//		HttpSession session = req.getSession();
//		session.setAttribute("orderitem", orderitem);
//		
//		resp.sendRedirect("HistoryDetails.jsp");
//	}
//
//}