package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;



public interface MenuDao {
	
	void addMenu(Menu menu);
	Menu getMenu(int MenuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu>getAllMenu();
	List<Menu>getMenuByRestaurantId(int restaurantId);

}
