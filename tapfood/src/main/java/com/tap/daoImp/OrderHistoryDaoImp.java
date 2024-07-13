package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.OrderHistoryDao;
import com.tap.model.OrderHistory;


public class OrderHistoryDaoImp implements OrderHistoryDao{
	
	
	final static	String INSERT_QUERY =	"INSERT into `orderhistory`"
			+ "(`orderHistoryId`, `orderId`, `userId`) "
			+ "values (?,?,?)";
	
	final static String SELECT_QUERY =	"SELECT * from `orderhistory` WHERE `orderHistoryId` = ?"; 
	
	final static String UPDATE_QUERY = "UPDATE `orderhistory` SET  `orderId` = ?, `userId` = ? WHERE `orderHistoryId` = ?";
	
	final static String DELETE_QUERY = "DELETE from `orderhistory` WHERE `orderHistoryId` = ?";
	
    final static String SELECT_ALL_QUERY = "SELECT * FROM `orderhistory`";       
    
    
    private Connection connection;
    
    public OrderHistoryDaoImp()
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
	public void addOrderHistory(OrderHistory orderhistory) {
		 PreparedStatement prepareStatement=null;

			try {
	
				prepareStatement = connection.prepareStatement(INSERT_QUERY);				
				prepareStatement.setInt(1,orderhistory.getOrderHistoryId());
				prepareStatement.setInt(2,orderhistory.getOrderId());
				prepareStatement.setInt(3,orderhistory.getUserId());

				prepareStatement.executeUpdate();
				
				
			  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement statement = null;
		 ResultSet res = null;
		 OrderHistory orderhistory = null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, orderHistoryId);
			
			res = statement.executeQuery();
			
			 if(res.next())
			 {
				
				int orderid = res.getInt("orderId");
				int userid = res.getInt("userId");
				
				orderhistory =	new OrderHistory(orderHistoryId, orderid, userid);
				
			 }
			
		} 
		 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			return orderhistory;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderhistory) {
		 PreparedStatement statement=null;
			
			try {
				
				statement = connection.prepareStatement(UPDATE_QUERY);
				
			
				statement.setInt(1,orderhistory.getOrderHistoryId());
				statement.setInt(2,orderhistory.getOrderId());
				statement.setInt(3,orderhistory.getUserId());;
				
				
				
				statement.executeUpdate();
				
		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		 PreparedStatement statement=null;
			
			try {
				statement = connection.prepareStatement(DELETE_QUERY);
				
				statement.setInt(1, orderHistoryId);
				statement.execute();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
    Statement statement = null;
		
		ResultSet res = null;
		
	    ArrayList<OrderHistory>  orderhistorylist =	new ArrayList<>();
  
		try {
			statement = connection.createStatement();
			
			res = statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
		
				
				int orderhistoryid   = res.getInt("orderHistoryId");
				int orderid = res.getInt("orderId");
				int userid = res.getInt("userId");
				
				OrderHistory orderhistory =	new OrderHistory(orderhistoryid, orderid, userid);
				
			orderhistorylist.add(orderhistory);
				
			}
			
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return orderhistorylist;
	}

}
