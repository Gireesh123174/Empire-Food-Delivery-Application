package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;


public class MenuDaoImp implements MenuDao{
	
	final static	String INSERT_QUERY =	"INSERT into `menu`"
			+ "(`menuId`, `name`, `price`, `description`, `imagePath`, `isAvailable`,`restaurantId`,`ratings`) "
			+ "values (?,?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY =	"SELECT * from `menu` WHERE `menuId` = ?"; 
	
	final static String UPDATE_QUERY = "UPDATE `menu` SET  `name` = ?, `price` = ?,"
      		+ "`description` = ?, `imagePath` = ?, `isAvailable` = ?, `restaurantId` = ?, `ratings` =? WHERE `menuId` = ?";
	
	final static String DELETE_QUERY = "DELETE from `menu` WHERE `menuId` = ?";
	
    final static String SELECT_ALL_QUERY = "SELECT * FROM `menu`";  
    
    final static String SELECT_MENU = "SELECT * FROM `menu`  WHERE `restaurantId` = ? ";
    
    
    private Connection connection;
    
    public MenuDaoImp()
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
	public void addMenu(Menu menu) {
		
		PreparedStatement prepareStatement=null;

		try {

			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, menu.getMenuId());
			prepareStatement.setString(2,menu.getName());
			prepareStatement.setInt(3,menu.getPrice());
			prepareStatement.setString(4,menu.getDescription());
			prepareStatement.setString(5,menu.getImagePath());
			prepareStatement.setBoolean(6,menu.getIsAvailable());
			prepareStatement.setFloat(7, menu.getRatings());
			prepareStatement.setInt(8, menu.getRestaurantId());
			

			prepareStatement.executeUpdate();
			
			
		  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Menu getMenu(int MenuId) {
		
		PreparedStatement statement = null;
		 ResultSet res = null;
		 Menu menu = null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, MenuId);
			
			res = statement.executeQuery();
			
			 if(res.next())
			 {
				
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String imagepath = res.getString("imagePath");
				Boolean isavailable = res.getBoolean("isAvailable");
				int restaurantid = res.getInt("restaurantId");
				Float ratings = res.getFloat("ratings");
			
				
		
				menu =	new Menu(MenuId, name, price, description, imagepath, isavailable,restaurantid,ratings);
				
			 }
			
		} 
		 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		
		 PreparedStatement statement=null;
			
			try {
				
				statement = connection.prepareStatement(UPDATE_QUERY);	
				statement.setString(1,menu.getName());
				statement.setInt(2,menu.getPrice());
				statement.setString(3,menu.getDescription());
				statement.setString(4,menu.getImagePath());
				statement.setBoolean(5,menu.getIsAvailable());
				statement.setInt(6, menu.getRestaurantId());
				statement.setFloat(7, menu.getRatings());
				statement.setInt(8, menu.getMenuId());
				

				statement.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		
    PreparedStatement statement=null;
		
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			
			statement.setInt(1, menuId);
			statement.execute();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenu() {
		
		  Statement statement = null;
			
			ResultSet res = null;
			
		    ArrayList<Menu>  menulist =	new ArrayList<>();
	  
			try {
				statement = connection.createStatement();
				
				res = statement.executeQuery(SELECT_ALL_QUERY);
				
				while(res.next())
				{
			
					int menuid = res.getInt("menuId");
					String name = res.getString("name");
					int price = res.getInt("price");
					String description = res.getString("description");
					String  imagepath = res.getString("imagePath");
					Boolean isavailable = res.getBoolean("isAvailable");
					int restaurantid = res.getInt("restaurantId");
					Float ratings = res.getFloat("ratings");
					
					
					
				Menu menu =	new Menu(menuid, name, price, description, imagepath, isavailable,restaurantid,ratings);
					
				menulist.add(menu);
					
				}
				
				
				
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			return menulist;
		}



	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId) {
		// TODO Auto-generated method stub
		
		PreparedStatement preparestatement;
		ResultSet res;
		Menu menu = null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		try {
			preparestatement = connection.prepareStatement(SELECT_MENU);
			preparestatement.setInt(1, restaurantId);
			res = preparestatement.executeQuery();
			while(res.next()) {
				int menuid = res.getInt("menuId");
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String  imagepath = res.getString("imagePath");
				Boolean isavailable = res.getBoolean("isAvailable");
				
				Float ratings = res.getFloat("ratings");
				

			 menu =	new Menu(menuid, name, price, description, imagepath, isavailable,restaurantId,ratings);
				
			 list.add(menu);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		
		return list;
	}
	
	}


