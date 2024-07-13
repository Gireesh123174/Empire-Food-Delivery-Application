package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;



public interface OrderItemsDao {
	
	void addOrderItems(OrderItems orderitems);
	OrderItems getOrderItems(int orderItemId);
	void updateOrderItems(OrderItems orderitems);
	void deleteOrderItems(int orderItemId);
	List<OrderItems>getAllOrderItems();
	List<OrderItems> getOrderItemByHistoryId(int historyId);
}
