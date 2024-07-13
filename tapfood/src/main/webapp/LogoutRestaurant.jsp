<?xml version="1.0" encoding="UTF-8"?>
<%@ page import = " com.tap.model.Restaurant,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>List of Restaurants</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
    body {

        margin: 0;
        text-align: center;

    }

    .container {    

        display: flex;
        justify-content: space-between;
        width: 75%; /* Set the width to 90% of the viewport width */
        margin: 0 auto; /* Center the container horizontally */
        flex-wrap: wrap; /* Allow items to wrap to the next line if needed */

    }
    .navigation button {
        background-color: red; /* Blue background */
        color: white; /* White text */
        border: none; /* No border */
        padding: 10px 20px; /* Padding */
        margin-right: 10px; /* Margin between buttons */
        cursor: pointer; /* Cursor style */
        border-radius: 5px; /* Rounded corners */
        transition: background-color 0.3s ease; /* Smooth background color transition */
        height: 40px;
    }

    .navigation button:hover {
        background-color: green; /* Darker blue on hover */
    }

    .row {
        width: 100%;
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px; /* Adjust the space between rows */

    }

    .item {

        width: calc(31% - 20px); /* Adjust the width of each item */
        height: -50%; /* Auto height to accommodate variable content */
        margin: 10px;
        padding: 10px;
        box-shadow: 0 0 10px rgb(232, 228, 228);
        border-radius: 4%;
        position: relative; /* Position relative for absolute positioning */
        display: flex; /* Display flex to allow flex items */
        flex-direction: column; /* Arrange flex items vertically */

    }

	.item:hover {
    transform: scale(1.1);

    }
    img {
    cursor: pointer;
    width: 100%; /* Set width to 100% to fill the container */
    height: 200px; /* Fixed height for all images */
    object-fit: cover; /* Scale image while maintaining aspect ratio */
    border-radius: 10%;
    }


    h3 {

        color: black;
        text-shadow: 0 0px 0px black;
        margin: 10px 0; /* Adjust margin for spacing */
        flex: 1; /* Allow h3 to grow to fill available space */

    }

    h5 {

        color: gray; /* Change color for additional text */
        margin: 0;

    }

    p {

        margin: 0px 0; /* Adjust margin for spacing */
		text-align: left;
    }

    .rating-box {

        background-color: green;
        color: white;
        padding: 5px;
        border-radius: 8px;
        font-size: 14px;

    }
	.user-text-name {
             /* Aligns the h1 content to the left side */
            margin-top:60px;
            margin-left: 10px; /* Adds a small margin to the left of the h1 content */
            color: Black;
            text-align: right;
        }
    .rating-container {

        display: flex;

        align-items: center;

    }
    .navigation {
    display: flex;
    text-align: right;
    padding: 20px;
    }

    .navigation a {
    text-decoration: none;
    color: black;
    }

    .navigation a:nth-child(1) {
    margin-right: 20px;  /* Adjust the margin as needed */
    }

    .navigation a i {
    font-size: 24px;  /* Adjust size as needed */
    }

    .navigation a i {
            margin-left: 20px;
            margin-right: 0px;
            text-decoration: none;
            color: red;
            font-size:40px;
        }
        
    .cartTab .btn {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
   }
   div {
    display: block;
    unicode-bidi: isolate;
    }
   .cartTab {
    width: 60px;
    background-color: #353432;
    color: #eee;
    position: fixed;
    top: 0;
    right: -400px;
    bottom: 0;
    display: grid;
    grid-template-rows: 70px 1fr 70px;
    transition: .5s;
}
.text-left{

 text-align: left;
}

   </style>
</head>

 <body>
    
     <div class="container">
       <div class="user-text-name"><h1>Your Delicious Restaurants are Here</h1> 
       
       <br>
       </div>  
     
     <div class="navigation"> 
        
        
        <button onclick="location.href='Login.jsp'">Log In</button>  
        <button onclick="location.href='SignUp.jsp'">Sign Up</button>  
         
          <a href="SignUp.jsp"><i class="fas fa-shopping-cart" ></i></a>
         
          
 
 </div>
         
    <%-- Counter variable to keep track of items displayed in a row --%>
    <% int counter = 0; %>
    <div class="row">
        <!-- JSP Code -->
        <%
              List<Restaurant> list = (List<Restaurant>)request.getAttribute("restaurants");
           
                for (Restaurant restaurant : list) {
                    %>
                    <%-- Check if the counter reaches 3, then start a new row --%>
                    <% if (counter == 3) { %>
                        </div><div class="row">
                        <% counter = 0; %>
                    <% } %>
                    <div class="item"> 
                    	<a href="MenuServlet2?restaurantId=<%= restaurant.getRestaurantId()%>"><img src="<%= restaurant.getImageUrl() %> " alt="<%= restaurant.getName() %> Image" ></a>
                    
                        
                        <div class="text-container">
                            <div class="rating-container">
                            
                                <h3><%= restaurant.getName() %></h3>
                                <div class="rating-box"><%= restaurant.getRating() %><span>&#9733;</span></div>
                            </div>
                           <div class="eta-time text-left"><%= restaurant.getEta() + " mins" %></div> 
                           <div class="cusinietype text-left"><p><%= restaurant.getCuisineType() %></p></div> 
                           <div class="address text-left"><p><%= restaurant.getAddress() %></p></div> 
                        </div>
                    </div>
                    <%-- Increment the counter for each item displayed --%>
                    <% counter++; %>
                    <%
                } 
            
        %>
        <!-- End of JSP Code -->
    </div>
    
 
    
</div>
    
</body>
</html>
