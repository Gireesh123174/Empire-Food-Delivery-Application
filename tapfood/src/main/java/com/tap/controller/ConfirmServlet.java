package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.OrderDaoImp;
import com.tap.daoImp.OrderItemsDaoImp;
import com.tap.daoImp.UserDaoImp;
import com.tap.model.CartCreator;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItems;

@WebServlet("/confirmservlet")
public class ConfirmServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 LocalDateTime now = LocalDateTime.now();
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//	        String orderId = now.format(formatter);
//	        HttpSession session = req.getSession();
//	        int orestaurantId=(int)session.getAttribute("restaurantId");
//	        int ouserId=(int)session.getAttribute("userId");
//	        int totalAmount=(int)session.getAttribute("totalAmount");
//	        String payment_method=req.getParameter("modeOfPayments");
//	        String status="Confirmed";
//	        String name=req.getParameter("name");
//	        String address=req.getParameter("address");
//	       // String state=req.getParameter("state");
//	      //  String city=req.getParameter("city");
//	      //  int zipcode=Integer.parseInt(req.getParameter("zipcode"));
//	        int historyid=(int)session.getAttribute("historyId");
//	      //  System.out.println(orderId +" "+ orestaurantId+","+ouserId+ totalAmount+ payment_method+ status);
//	        
//	        
//	        Order order = new Order(orderId, orestaurantId, ouserId, totalAmount, payment_method, status);
//
//	     
//	     //(orderid, restaurantid, userid, totalamount, modeofpayments, status)            
//	     
//	  //   Order order =	new Order(orderid, restaurantid, userid, totalamount, modeofpayments, status);
//			
//	     
//	     OrderDaoImp daoI = new OrderDaoImp();
//         daoI.addOrder(order);
//         session.setAttribute("orderId", orderId);
//         session.setAttribute("name", name);
//         session.setAttribute("address", address);
//        // session.setAttribute("state", state);
//       //  session.setAttribute("city", city);
//      //   session.setAttribute("zipcode", zipcode);
//         session.setAttribute("status", status);
//         session.setAttribute("modeOfPayments", payment_method);
//         resp.sendRedirect("Confirm.jsp");
		
		
		UserDaoImp userDao = new UserDaoImp();

		PrintWriter out = resp.getWriter();

		LocalDateTime now = LocalDateTime.now();

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	        String orderId = now.format(formatter);

	        HttpSession session = req.getSession();

	        int restaurant_Id=(int)session.getAttribute("restaurantId");

	        int userId=(int)session.getAttribute("userId");

	        int historyId=(int)session.getAttribute("historyId");

	        
	        int menuId = (int) session.getAttribute("menuid");

			CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");

			for (CartItem item : cartCreator.getAll().values()) {

				int orderItemId=0;

//				int menuId = item.getMenuId();

				String name = item.getName();

				int quantity = item.getQuantity();

				int price = item.getPrice();
				
				int restaurantId = item.getRestaurantId();

				OrderItems orderitem = new OrderItems(orderItemId, userId, menuId, name, quantity, price,restaurantId,historyId);

				OrderItemsDaoImp daoI = new OrderItemsDaoImp();

				Connection connection = userDao.getConnection();

                if (connection == null) {

                    out.print("Error connecting to the database");

                    return;

                }

                daoI.setConnection(connection);

				daoI.addOrderItems(orderitem);

			}


	        int totalAmount=(int)session.getAttribute("totalAmount");

	        

	        String modeOfPayment=req.getParameter("payment_method");

	        String status="confirmed";

	        String orderName=req.getParameter("name");

	        String address=req.getParameter("address");

	        String state=req.getParameter("state");

	        String city=req.getParameter("city");

	        int pincode=Integer.parseInt(req.getParameter("pincode"));

	      //  System.out.println(orderId +" "+ orestaurantId+","+ouserId+ totalAmount+ payment_method+ status);
	        OrderDaoImp odi = new OrderDaoImp();

	        Order order = new Order(orderId,restaurant_Id,userId,totalAmount,modeOfPayment,status,historyId);

         odi.addOrder(order);

         

         

         session.setAttribute("orderId", orderId);

         session.setAttribute("orderName", orderName);

         session.setAttribute("address", address);

         session.setAttribute("state", state);

         session.setAttribute("city", city);

         session.setAttribute("pincode", pincode);

         session.setAttribute("status", status);

         session.setAttribute("modeOfPayment", modeOfPayment);

         resp.sendRedirect("Confirm.jsp");
	}

}