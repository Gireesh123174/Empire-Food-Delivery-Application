<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login Page</title>
<!-- Include FontAwesome CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0px;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
           
        }
        .login-form {
            background-color: white;
            padding: 40px;
            border-radius: 35px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-form h2 {
            margin-bottom: 15px;
            text-align: center;
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            /* Add left padding for icon */
            padding-left: 30px;
        }
        .login-form input[type="text"]::placeholder,
        .login-form input[type="password"]::placeholder {
            color: #999; /* Placeholder color */
        }
        .login-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: green;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .login-form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        /* Icon styling */
        .fa {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: green; 
        }
        
        .error-message{
         
           color: red; 
           padding-top: 10px;
           text-align: center;
         
        
        }
        .container-forgot
        {
        
         padding-top: 10px;
        }
        
    </style>


</head>
<body>
    <div class="container">
        <form class="login-form" action="Restaurant" method="post">
            <h2>Login</h2>
            <!-- Username field with icon -->
            <div style="position: relative;">
                   <i class="fa fa-user"></i>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <!-- Password field with icon -->
            <div style="position: relative;">
                   <i class="fa fa-lock"></i>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            
            
            
            <input type="submit" value="Login">
            
            <div class="container-forgot">
                  <a href="forgotPassword.jsp">forgot password</a>
            
            </div>
            
            <% 
                String error = (String)request.getAttribute("error");
                if (error != null && !error.isEmpty()) { %>
                    <div class="error-message"><%= error %></div>
            <% } %>
        </form>
    </div>
</body>
</html>