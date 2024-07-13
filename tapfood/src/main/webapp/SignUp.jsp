<%@ page import="com.tap.model.User,java.util.List" %>
<%@ page import="com.tap.daoImp.UserDaoImp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            padding: 0px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .title {
            font-size: 30px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .subtitle {
            font-size: 15px;
            color: #666;
            margin-bottom: 20px;
        }
        .input-container {
            margin-bottom: 20px;
            position: relative;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="phone"] {
            width: 100%;
            padding: 12px 40px 12px 12px;
            border-radius: 8px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            box-sizing: border-box;
            outline: none;
        }
        .fa {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            right: 10px;
            color: #888;
        }
        .button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            background-color: #6a1b9a;
            color: #fff;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #4a148c;
        }
        .or {
            text-align: center;
            margin: 20px 0;
            color: #666;
        }
        .login-link {
            text-align: center;
            color: #6a1b9a;
            margin-top: 20px;
        }
         .message {
            color: green;
            text-align: center;
            
        }
    </style>
</head>
<body>
  
    
    <% 
    if (request.getMethod().equals("POST")) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phoneNo"));
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        UserDaoImp u = new UserDaoImp();
        User u1 = new User(0, name, email, phone, null, username, password, null, null, null);
        if (u.addUser(u1) > 0) {
    %>
            <div class="message">Your registration was successful!</div>
            <script>
                setTimeout(function() {
                    window.location.href = "Login.jsp";
                }, 2000); // 2000 milliseconds delay (2 seconds)
            </script>
    <% 
        } else {
    %>
            <div class="message">Sign up failed. Please try again.</div>
    <% 
        }
    }
    %>
    
     <div class="container">
        <form method="post">
            <h2 class="title">Sign up</h2>
            <p class="subtitle">Create your account</p>
            
            <div class="input-container">
                <input type="text" id="name" name="name" placeholder="Name" required>
                <i class="fa fa-user"style="font-size:20px;color:green"></i>
            </div>
            <div class="input-container">
                <input type="email" id="email" name="email" placeholder="Email" required>
                <i class="fa fa-envelope" style="font-size:20px;color:green"></i>
            </div>
            <div class="input-container">
                <input type="phone" id="phone" name="phoneNo" placeholder="Phone" required>
                <i class="fa fa-phone" style="font-size:20px;color:green"></i>
            </div>
            <div class="input-container"> 
                <input type="text" id="username" name="userName" placeholder="UserName" required>
                <i class="fa fa-user"style="font-size:20px;color:green"></i>
            </div>
            
            <div class="input-container">
                <input type="password" id="password" name="password"  placeholder="******" required>
                <i class="fa fa-lock"style="font-size:20px;color:green;"></i>
            </div>
            <button class="button">Sign up</button>
            <p class="or">Or</p>   
            <p class="login-link">Already have an account? <a href="Login.jsp">Login</a></p>
        </form>
    </div>
</body>
</html>
