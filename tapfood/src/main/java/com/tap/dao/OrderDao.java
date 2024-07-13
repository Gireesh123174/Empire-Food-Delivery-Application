package com.tap.dao;

import java.util.List;

import com.tap.model.Order;



public interface OrderDao {
	
	void addOrder(Order order);
	Order getOrder(int OrderId);
	void updateOrder(Order order);
	void deleteOrder(int OrderId);
	List<Order>getAllOrder();

}
