<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import = " com.tap.model.Menu,java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Menu List</title>
    <style>
        body {
            margin: 0;
            text-align: center;
        }
        .container {  
            display: flex;
            justify-content: space-between;
            width: 50%;
            margin: auto;
            flex-wrap: wrap;
            flex-direction: column;
            
            
        }
        .row {
            width: 100%;
            display: flex;
            justify-content: space-between;
            margin-bottom: 0px;
            
        }
        .item {
            width: calc(100% - 100px);
            height: 60%;
            margin: 20px; /* Adjusted margin to reduce space between items */
            padding: 5px;
            box-shadow: 0px 0px 3px rgb(232, 228, 228);
            border-radius: 10%;
            position: relative;
            display: flex;
            flex-direction: row;   
                 
        }
        
        .item img:hover{
          transform : scale(1.1);
          
        }
        
        .content {
            flex: 1;
            padding: 0 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            
        }
        
        img {
            cursor: pointer;
            width: 30%;
            height: 110px;
            border-radius: 10%;
            float: right;
            border: 2px solid #ddd;
            
        }
        h3 {
            color: black;
            text-shadow: 0 0px 0px black;
            margin: 5px 0;
            text-align: left;
            
        }
        
        p {
            margin: 3px 0;
            text-align: left;
        }
        .rating-box
        {
           text-align: left;
           color: green;
        }
         button {
            position: absolute;
            top: 88%;
            left: 84%;
            transform: translate(-50%, -50%);
            background-color: #f9fcfa;
            color: green;
            border: none;
            border-radius: 18%;
            width: 130px;
            height: 40px;
            font-weight: bold;
            font-size: 15px;
            cursor: pointer;
            border: 1px solid black;
            
        }
        h1{
        
        background-color: blue;
        height: 50px;
        font-family:Monaco;
        color: white;
        
        }
        
    </style>
</head>
<body>
   
    <h1>Menu Browser</h1>
    <div class="container">
    
    
        <%-- Counter variable to keep track of items displayed in a row --%>
        <% int counter = 0; %>
        <div class="row">
            <!-- JSP Code -->
            <%
            
            List<Menu> list = (List<Menu>)request.getAttribute("menus");
            
            
              
                    for (Menu menu : list) {
                        %>
                        <%-- Check if the counter reaches 3, then start a new row --%>
                        <% if (counter == 1) { %>
                            </div><div class="row">
                            <% counter = 0; %>
                        <% } %>
                        <div class="item"> 
                            <div class="content">
                                <div class="rating-container">
                                    <h3><%= menu.getName() %></h3>
                                </div>
                                <p><%="₹ " +menu.getPrice() %></p>
                                    <div class="rating-box" ><%=menu.getRatings() %> <span>&#9733;</span></div>
                                <p><%= menu.getDescription() %></p>
                            </div>
                            <img src="<%= menu.getImagePath() %>" />
                             <div class="button-container">
                             
                          <form action="CallServletCart" method="post">
                          
                          <input type="hidden" name="name" value="<%=menu.getName() %>" />
                          <input type="hidden" name="imagePath" value="<%=menu.getImagePath() %>" />
                          <input type="hidden" name="menuId" value="<%=menu.getMenuId() %>" />
                          <input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId() %>" />
                          <input type="hidden" name="ratings" value="<%=menu.getRatings() %>" />
                          <input type="hidden" name="price" value="<%=menu.getPrice() %>" />
                          <input type="hidden" name="description" value="<%=menu.getDescription() %>" />
                          <input type="hidden" name="quantity" value="1" />
                             
                        <button>ADD</button>
                                 
                          </form>  
                    </div>
                        </div>
                        <%-- Increment the counter for each item displayed --%>
                        <% counter++; %>
                        <%
                    }
               // }
            %>
            <!-- End of JSP Code -->
        </div>
    </div>
</body>
</html>
