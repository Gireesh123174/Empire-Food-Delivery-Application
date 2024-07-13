package com.tap.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/newPassword")
public class NewPasswordServlet extends HttpServlet{
	
		private static final long serialVersionUID = 1L;
		
		
		 static final String HASH_ALGORITHM = "SHA-256";
		    
		    private String encryptPassword(String password) {
		        try {
		            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
		            byte[] hashBytes = digest.digest(password.getBytes());
		            return Base64.getEncoder().encodeToString(hashBytes);
		        } catch (NoSuchAlgorithmException e) {
		            e.printStackTrace();
		         
		            return null;
		        }
		    }
		    

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			HttpSession session = request.getSession();
			String newPassword = request.getParameter("password");
			String confPassword = request.getParameter("confPassword");
			RequestDispatcher dispatcher = null;
			if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tapfood1", "root",
							"root");
					PreparedStatement pst = con.prepareStatement("update user set password = ? where email = ? ");
					pst.setString(1, encryptPassword(newPassword));
					pst.setString(2, (String) session.getAttribute("email"));

					int rowCount = pst.executeUpdate();
					if (rowCount > 0) {
						request.setAttribute("status", "resetSuccess");
						dispatcher = request.getRequestDispatcher("Login.jsp");
					} else {
						request.setAttribute("status", "resetFailed");
						dispatcher = request.getRequestDispatcher("Login.jsp");
					}
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


		private void newPassword() {
			// TODO Auto-generated method stub
			
		}

	}

