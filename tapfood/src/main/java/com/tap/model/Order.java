package com.tap.model;

public class Order {
	
	private String orderId;
	private int restaurantId;
	private int userId;
	private int totalAmount;
	private String modeOfPayments;
	private String status;
	int historyId;
	
	public Order() {
		
		
	}

	public Order(String orderId, int restaurantId, int userId, int totalAmount, String modeOfPayments, String status,int historyId) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayments = modeOfPayments;
		this.status = status;
		this.historyId = historyId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayments() {
		return modeOfPayments;
	}

	public void setModeOfPayments(String modeOfPayments) {
		this.modeOfPayments = modeOfPayments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public int getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	

}
