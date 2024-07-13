package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImp.UserDaoImp;
import com.tap.model.User;

public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		    UserDaoImp r = new UserDaoImp();

	        List<User> list = r.getAllUsers();

	        req.setAttribute("users", list);
	        RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");

	        rd.forward(req, resp);
		
		
	}

}
