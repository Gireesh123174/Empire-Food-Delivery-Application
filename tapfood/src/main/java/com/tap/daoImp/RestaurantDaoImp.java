package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;



public class RestaurantDaoImp implements RestaurantDao{
	
	

	final static	String INSERT_QUERY =	"INSERT into `restaurant`"
			+ "(`restaurantId`, `name`, `imageUrl`, `rating`, `eta`, `cuisineType`,`Address`,`isActive`,`restaurantOwnerId`) "
			+ "values (?,?,?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY =	"SELECT * from `restaurant` WHERE `restaurantId` = ?"; 
	
	final static String UPDATE_QUERY = "UPDATE `restaurant` SET  `name` = ?, `imageUrl` = ?,"
      		+ "`rating` = ?, `eta` = ?, `cuisineType` = ?, `Address` = ?, `isActive` =?, `restaurantOwnerId`=? WHERE `restaurantId` = ?";
	
	final static String DELETE_QUERY = "DELETE from `restaurant` WHERE `restaurantId` = ?";
	
    final static String SELECT_ALL_QUERY = "SELECT * FROM `restaurant`";       
    
    
    private Connection connection;
	
    public RestaurantDaoImp()
    {
    		
    	String url = "jdbc:mysql://localhost:3306/tapfood1";
		String username = "root";
		String password = "root";
		
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
        catch (ClassNotFoundException  e) {
		
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
  	
    }
	
	
	

	@Override
	public void addrestaurant(Restaurant restaurant) {
		
		PreparedStatement prepareStatement=null;

		try {

			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, restaurant.getRestaurantId());
			prepareStatement.setString(2,restaurant.getName());
			prepareStatement.setString(3,restaurant.getImageUrl());
			prepareStatement.setFloat(4,restaurant.getRating());
			prepareStatement.setInt(5,restaurant.getEta());
			prepareStatement.setString(6,restaurant.getCuisineType());
			prepareStatement.setString(7, restaurant.getAddress());
			prepareStatement.setBoolean(8, restaurant.getIsActive());
			prepareStatement.setInt(9, restaurant.getRestaurantOwnerId());
			
			
			
			prepareStatement.executeUpdate();
			
			
		  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public Restaurant getrestaurant(int restaurantId) {
		PreparedStatement statement = null;
		 ResultSet res = null;
		 Restaurant  restaurant= null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, restaurantId);
			
			res = statement.executeQuery();
			
			 if(res.next())
			 {
				
				String name = res.getString("name");
				String imageurl = res.getString("imageUrl");
				Float rating = res.getFloat("rating");
				int eta = res.getInt("eta");
				String cuisinetype = res.getString("cuisineType");
				String address = res.getString("Address");
				Boolean isactive = res.getBoolean("isActive");
				int restaurantownerid = res.getInt("restaurantOwnerId");
				
				
		
			 restaurant = new Restaurant(restaurantId, name, imageurl, rating, eta, cuisinetype,address,isactive,restaurantownerid);
				
			 }
			
		} 
		 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			return restaurant;
	}

	@Override
	public void updaterestaurant(Restaurant restaurant) {
		
     PreparedStatement statement=null;
		
		try {
			
			statement = connection.prepareStatement(UPDATE_QUERY);
		
		    statement.setString(1,restaurant.getName());
		    statement.setString(2,restaurant.getImageUrl());
			statement.setFloat(3,restaurant.getRating());
			statement.setInt(4,restaurant.getEta());
			statement.setString(5,restaurant.getCuisineType());
			statement.setString(6, restaurant.getAddress());
			statement.setBoolean(7, restaurant.getIsActive());
			statement.setInt(8, restaurant.getRestaurantOwnerId());
			statement.setInt(9, restaurant.getRestaurantId());
			

			statement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleterestaurant(int restaurantId) {
		
    PreparedStatement statement=null;
		
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			
			statement.setInt(1, restaurantId);
			statement.execute();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	 @Override
	    public List<Restaurant> getAllrestaurant() {
	        Statement statement = null;
	        ResultSet res = null;
	        ArrayList<Restaurant> restaurantlist = new ArrayList<>();

	        try {
	            statement = connection.createStatement();
	            res = statement.executeQuery(SELECT_ALL_QUERY);

	            while (res.next()) {
	                int restaurantid = res.getInt("restaurantId");
	                String name = res.getString("name");
	                String imageurl = res.getString("imageUrl");
	                Float rating = res.getFloat("rating");
	                int eta = res.getInt("eta");
	                String cuisinetype = res.getString("cuisineType");
	                String address = res.getString("Address");
	                Boolean isactive = res.getBoolean("isActive");
	                int restaurantownerid = res.getInt("restaurantOwnerId");

	                Restaurant restaurant = new Restaurant(restaurantid, name, imageurl, rating, eta, cuisinetype,
	                        address, isactive, restaurantownerid);
	                restaurantlist.add(restaurant);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources in finally block to ensure they are closed even if an
	            // exception occurs
	            try {
	                if (res != null) {
	                    res.close();
	                }
	                if (statement != null) {
	                    statement.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return restaurantlist;

	    }
	}

