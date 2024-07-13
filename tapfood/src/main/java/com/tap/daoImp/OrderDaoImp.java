package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Order;


public class OrderDaoImp implements OrderDao{
	
	
	final static	String INSERT_QUERY =	"INSERT into `order`"
			+ "(`orderId`, `restaurantId`, `userId`, `totalAmount`, `modeOfPayments`, `status`, `historyId`) "
			+ "values (?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY =	"SELECT * from `order` WHERE `orderId` = ?"; 
	
	final static String UPDATE_QUERY = "UPDATE `order` SET  `restaurantId` = ?, `userId` = ?,"
      		+ "`totalAmount` = ?, `modeOfPayments` = ?, `status` = ?, `historyId` = ?  WHERE `orderId` = ?";
	
	final static String DELETE_QUERY = "DELETE from `order` WHERE `orderId` = ?";
	
    final static String SELECT_ALL_QUERY = "SELECT * FROM `order`";       
    
    
    private Connection connection;
    
    public OrderDaoImp()
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
	public void addOrder(Order order) {
		
		 PreparedStatement prepareStatement=null;

			try {
	
				prepareStatement = connection.prepareStatement(INSERT_QUERY);
				
				prepareStatement.setString(1,order.getOrderId());
				prepareStatement.setInt(2,order.getRestaurantId());
				prepareStatement.setInt(3,order.getUserId());
				prepareStatement.setInt(4,order.getTotalAmount());;
				prepareStatement.setString(5,order.getModeOfPayments());
				prepareStatement.setString(6,order.getStatus());
				prepareStatement.setInt(7,order.getHistoryId());
				
				
				
				prepareStatement.executeUpdate();
				
				
			  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public Order getOrder(int OrderId) {
		
		PreparedStatement statement = null;
		 ResultSet res = null;
		 Order order = null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, OrderId);
			
			res = statement.executeQuery();
			
			 if(res.next())
			 {
				
				int restaurantid = res.getInt("restaurantId");
				String userid = res.getString("userId");
				int totalamount = res.getInt("totalAmount");
				String modeofpayments = res.getString("modeOfPayments");
				String status = res.getString("status");
				int historyId = res.getInt("historyId");				
		
				order =	new Order(userid, restaurantid, OrderId, totalamount, modeofpayments, status,historyId);
				
			 }
			
		} 
		 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			return order;
		
	}

	@Override
	public void updateOrder(Order order) {
		 PreparedStatement statement;
			
			try {
				
				statement = connection.prepareStatement(UPDATE_QUERY);
				
				statement.setInt(1,order.getRestaurantId());
				statement.setInt(2,order.getUserId());
				statement.setInt(3,order.getTotalAmount());;
				statement.setString(4,order.getModeOfPayments());
				statement.setString(5,order.getStatus());
				statement.setInt(6,order.getHistoryId());
				
				statement.setString(7,order.getOrderId());
				
				statement.executeUpdate();
				
		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteOrder(int OrderId) {
		 PreparedStatement statement=null;
			
			try {
				statement = connection.prepareStatement(DELETE_QUERY);
				
				statement.setInt(1, OrderId);
				statement.execute();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public List<Order> getAllOrder() {
		
       Statement statement = null;
		
		ResultSet res = null;
		
		Order order=null;
		
	    ArrayList<Order>  orderlist =	new ArrayList<Order>();
  
		try {
			statement = connection.createStatement();
			
			res = statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				
				String orderid = res.getString("orderId");
				
				int restaurantid = res.getInt("restaurantId");
				int userid = res.getInt("userId");
				int totalamount = res.getInt("totalAmount");
				String modeofpayments = res.getString("modeOfPayments");
				String status = res.getString("status");
				int historyId = res.getInt("historyId");				
				
			 order =	new Order(orderid, restaurantid, userid, totalamount, modeofpayments, status,historyId);
				
			orderlist.add(order);
				
			}
			
			
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return orderlist;

		
		
	}

}
