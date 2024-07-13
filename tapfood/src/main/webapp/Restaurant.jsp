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


        header {
        background-color: #00bcd4;
        color: white;
        padding: 0px;
        text-align: center;
        top: 0;
        position: fixed;
        width: 100%;
        z-index: 1000;
            height: 70px;
        
    }

    .container {    
        display: flex;
        justify-content: space-between;
        width: 75%; /* Set the width to 90% of the viewport width */
        margin: 0 auto; /* Center the container horizontally */
        flex-wrap: wrap; /* Allow items to wrap to the next line if needed */
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
        margin-top:60px;
        margin-left: 10px; /* Adds a small margin to the left of the h1 content */
        color: Black;
        text-align: right;
    }

    .rating-container {
        display: flex;
        align-items: center;
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
        transition: .5s;
    }
    .text-left{
        text-align: left;
    }
    

.logo-img img
{

  width: 50px;
  height:auto;
  border-radius: 90%;

}



  .navigation {
        display: flex;
        justify-content: flex-end;
        align-items: flex-start;
        padding: 10px 30px 0 0;
    }

    .navigation input[type="text"] {
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        margin-right: 10px;
    }

    .navigation #searchButton {
        background-color: #f42f06;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .navigation #searchButton:hover {
        background-color: white;
        color:#f42f06;
    }

    .navigation a {
        text-decoration: none;
        color: black;
        margin-left: 20px;
    }

    .navigation a:nth-child(1) {
        margin-right: 20px;
    }

    .navigation a i {
    font-size: 35px;
    margin-right: 10px;
    text-decoration: none;
    color: #f42f06;
}
   .navigation button {
       
        
        border: none;
        font-weight: bold;
        padding: 10px 18px;
        margin-left: 10px;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .navigation button:hover {
        background-color: white;
        color:#f42f06;
    }


.branding {

        display: flex;
        align-items: center;
        font-size: 55px;
    color: #f6ff00fc;
    text-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    font-family: fantasy;
    position: absolute;
    top: 0px;
    left:10%;
    
    }
    

    .branding img {
        width: 50px;
        height: auto;
        margin-right: 10px;
        border-radius: 30px;
    }
        
   </style>
</head>

<body>
    

   
     
     <header>
        <div class="navigation">
            <!-- Your existing navigation buttons -->
            <input type="text" placeholder="Search for Restaurant or Food" id="searchInput">
            <button id="searchButton"><i class="fas fa-search"></i></button>
            <a href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
            <button onclick="location.href='RestaurantServlet'">Home</button>
            <button onclick="location.href='OrderHistoryServlet'">Orders</button>
            
            <button onclick="location.href='CallServlet2'">Logout</button>
            <button id="darkModeToggle"><i class="fas fa-moon"></i></button>
            
            <!-- Add the toggle button here -->
        </div>
      
        
                <div class="branding">
            <img src="Logo.jpg" alt="Logo">
            EMPIRE
        </div>
    </header>
        
        
        
    </header>
     
     
     <div class="container">
    <div class="user-text-name">
        <h1>Welcome <%=request.getAttribute("username") %> Your Delicious Restaurants are Here</h1>
        <br>
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
            <a href="MenuServlet2?restaurantId=<%= restaurant.getRestaurantId()%>">
                <img src="<%= restaurant.getImageUrl() %>" alt="<%= restaurant.getName() %> Image">
            </a>
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
        <% } %>
        <!-- End of JSP Code -->
    </div>
</div>
    
</body>
</html>