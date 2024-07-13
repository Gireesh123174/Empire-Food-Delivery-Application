<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>checkout page</title>
<style type="">

.container {
  width: 400px;
  margin: 0 auto;
  padding: 20px;
  padding-top : 200;
  background-color: #f0f0f0;
  border-radius: 8px;
  box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
}

form {
  font-family: Arial, sans-serif;
}

label {
  margin-top: 10px;
  display: block;
  font-weight: bold;
}

input[type="text"],
select {
  width: 100%;
  padding: 8px;
  margin: 5px 0 15px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}

input[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
}




</style>

</head>
<body>

<div class="container">
    <div class="title">Order Confirmation</div>
    <div class="content">
      <form action="confirmservlet">
        <div class="user-details">
       
          
          <div class="input-box">
            <span class="details">Name</span>
            <input type="text" placeholder="Enter your name" name="Name" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" placeholder="Enter your number" name="phone number" required>
          </div>
           <div class="input-box">
            <span class="details">Pincode</span>
            <input type="text" placeholder="Enter your pinpcode" name="pincode" required>
          </div>
          <div class="input-box">
            <span class="details">Building</span>
            <input type="text" placeholder="Enter your flat number" name="building" required>
          </div>
          <div class="input-box">
            <span class="details">Landmark</span>
            <input type="text" placeholder="Enter your Landmark" name="landmark" required>
          </div>
          <div class="input-box">
            <span class="details">Address</span>
            <input type="text" placeholder="Enter your Address" name="address" required>
          </div>
          <div class="input-box">
            <span class="details">City</span>
            <input type="text" placeholder="Enter your city" name="city" required>
          </div>
          
          <div class="input-box">
            <span class="details">State</span>
            <input type="text" placeholder="Enter your state" name="state" required>
          </div>
        
         
          
       <div class="input-box">   
  <span class="details">Choose a payment method:</span>
  <select id="payment-method" name="payment_method" required>
    <option value="COD">Cash on Delivery (COD)</option>
    <option value="UPI">Unified Payments Interface (UPI)</option>
    <option value="Debit Card">Debit Card</option>
    <option value="Credit Card">Credit Card</option>
  </select>
  </div>
        
          <div class="button">
          
           <input type="submit" value="Confirm">
           
          </div>
       </div>
      </form>
    </div>
  </div>


</body>
</html>