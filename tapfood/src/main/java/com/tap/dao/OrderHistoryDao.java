package com.tap.dao;

import java.util.List;


import com.tap.model.OrderHistory;

public interface OrderHistoryDao {
	
	void addOrderHistory(OrderHistory orderhistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderhistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory>getAllOrderHistory();

	
	}
