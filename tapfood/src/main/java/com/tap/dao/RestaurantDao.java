package com.tap.dao;

import java.util.List;
import com.tap.model.Restaurant;

public interface RestaurantDao {
    void addrestaurant(Restaurant restaurant);
    Restaurant getrestaurant(int restaurantId);
    void updaterestaurant(Restaurant restaurant);
    void deleterestaurant(int restaurantId);
	List<Restaurant> getAllrestaurant();
   
    
    	
}
