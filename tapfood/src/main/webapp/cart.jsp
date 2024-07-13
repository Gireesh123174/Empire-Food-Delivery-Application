<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import = " com.tap.model.CartCreator,java.util.List" %>
<%@ page import = " com.tap.model.CartItem,java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cart shopping</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

.cart-container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

.cart-item {
    border: 1px solid #ddd;
    margin-bottom: 20px;
    padding: 10px;
    overflow: hidden;
    border-radius: 8px;
    background-color: #fff;
    transition: all 0.3s ease;
}

.cart-item:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.cart-item img {
    width: 100px;
    height: 100px;
    float: left;
    margin-right: 10px;
    border-radius: 8px;
}

.cart-details {
    float: left;
}

.cart-name {
    margin: 0;
    color: #333;
    font-size: 18px;
}

.cart-price, .cart-quantity {
    margin: 5px 0;
    color: #777;
}

.quantity-button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 20%;
    width: 30px;
    height: 30px;
    cursor: pointer;
    font-size: 16px;
}

.quantity-button:hover {
    background-color: #0056b3;
}

.cart-quantity {
    font-size: 16px;
    margin: 0 5px; /* Add margin around the quantity number */
}

.cart-total {
    text-align: right;
    margin-top: 20px;
    font-weight: bold;
    font-size: 20px;
}

button {
    background-color: #28a745;
    color: #fff;
    border: none;
    border-radius: 4px;
    padding: 10px 20px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    margin-top: 5px; /* Add margin to create space between buttons */
}

button:hover {
    background-color: #218838;
}

p {
    text-align: center;
    color: #777;
}

.cart-update,
.cart-actions {
    margin-top: 10px;
}

.cart-update form,
.cart-actions form,
.cart-actions div {
    display: inline-block;
    margin-right: 10px;
}

.cart-actions div:last-child {
    margin-right: 0;
}



</style>

</head>
<body>

<div class="cart-container">

<h2>Your Shopping Cart</h2>
    <% CartCreator  cart  = (CartCreator) session.getAttribute("cartCreator");
        if(cart != null && ! cart.getAll().isEmpty()) {
        	int total = 0;
        	for(CartItem item : cart.getAll().values()) {
        		total += item.getPrice() * item.getQuantity(); %>		
        		 <div class="cart-item">
                    <img class="cart-image" src="<%= item.getImagePath() %>" alt="Product Image">
                    <div class="cart-details">
                        <h4 class="cart-name"><%=item.getName() %></h4>
                        <p class="cart-price">Price: &#8377; <%=item.getPrice() %></p>
                        
                        <div class="cart-update">
                            
                            <%
                               int quantity = item.getQuantity();
                              %>
                                 <form action="UpdateQuantityServlet" method="post" style="display: inline;">
                                 <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                 <input type="hidden" name="quantity" value="<%= (quantity > 0) ? quantity - 1 : 0 %>">
                                  <input class="quantity-button" type="submit" value="-">
                                  </form>
                           
                            <span class="cart-quantity"><%=item.getQuantity() %></span>
                           
                            <form action="UpdateQuantityServlet" method="post" style="display: inline;">
                                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                                <input class="quantity-button" type="submit" value="+">
                            </form>
                        </div>
                        
                        <div class="cart-actions">
                            <form method="post" action="RemoveFromCartServlet">
                                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <button type="submit">Remove</button>
                            </form>
                            
                            <div class="cart-add-more">
                                <a href="MenuServlet2?restaurantId=<%=item.getRestaurantId() %>"><button>Add More Items</button></a>
                            </div>
                           
                            <div class="cart-proceed">
                                <form method="post" action="checkOut">
                                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <input type="hidden" name="total" value="<%= total %>">
                                    <button type="submit">Check Out</button>
                                </form>
                            
                            </div>
                        </div>
                    </div>
                </div>
        		<%
        	}
        	%>
        		
        	<div class="cart-total">
        	  Total: &#8377; <%= total %>
        	</div>
        	  
        <% } else { %>
        	<p>No items in your cart.</p>
        <% } %>
</div>

</body>
</html>