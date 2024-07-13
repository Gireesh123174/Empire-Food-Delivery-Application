package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoImp implements UserDao {
	
	
	final static String INSERT_QUERY =	"INSERT into `user`"
			+ "(`userId`, `name`, `email`, `phoneNo`, `address`, `userName`,`password`,`role`) "
			+ "values (?,?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY =	"SELECT * from `user` WHERE `userId` = ?"; 
	
	final static String UPDATE_QUERY = "UPDATE `user` SET  `name` = ?, `email` = ?,"
      		+ "`phoneNo` = ?, `address` = ?, `userName` = ?, `password` = ?, `role` =? WHERE `userId` = ?";
	
	final static String DELETE_QUERY = "DELETE from `user` WHERE `userId` = ?";
	
    final static String SELECT_ALL_QUERY = "SELECT * FROM `user`";     
    
    final static String USER_PASSWORD = "SELECT * FROM user WHERE `username` = ? AND `password` = ?";
    
    final static String USER_ID = "SELECT userId FROM user WHERE `username` = ? ";
    
    
    
    static final String HASH_ALGORITHM = "SHA-256";
    
    private String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
         
            return null;
        }
    }
    
    
    private String encryptUsername(String username) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = digest.digest(username.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    private Connection connection;
    
    public UserDaoImp()
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
	public int addUser(User user) {
		
		 PreparedStatement prepareStatement=null;
		 int rowsAffected =0;

			try {
	
				prepareStatement = connection.prepareStatement(INSERT_QUERY);
				
				prepareStatement.setInt(1, user.getUserId());
				prepareStatement.setString(2,user.getName());
				prepareStatement.setString(3,user.getEmail());
				prepareStatement.setInt(4,user.getPhoneNo());
				prepareStatement.setString(5,user.getAddress());;
				
				prepareStatement.setString(6, encryptUsername(user.getUserName()));

			//	prepareStatement.setString(6,user.getUserName());
				
				// Encrypt the password before storing it
	            String encryptedPassword = encryptPassword(user.getPassword());
	            
	            
				prepareStatement.setString(7,encryptedPassword);
				prepareStatement.setString(8, user.getRole());
				
				
				rowsAffected =	prepareStatement.executeUpdate();
				
				
			  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rowsAffected;
			
	}
	
	

	@Override
	public User getUser(int UserId) {
		PreparedStatement statement = null;
		 ResultSet res = null;
		 User user = null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, UserId);
			
			res = statement.executeQuery();
			
			 if(res.next())
			 {
				
				String name = res.getString("name");
				String email = res.getString("email");
				int phone = res.getInt("phoneNo");
				String address = res.getString("address");
				String username = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("Role");
				Date createdate = res.getDate("CreatedDate");
				Date lastlogintime = res.getDate("LastLogin");
				
				user =	new User(UserId, name, email, phone, address, username,password,role,createdate,lastlogintime);
				
			 }	
		} 
		 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			return user;
		}

	

	@Override
	public void updateUser(User user) {

      PreparedStatement statement=null;

   try
      {
			
			statement = connection.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1,user.getName());
			statement.setString(2,user.getEmail());
			statement.setInt(3,user.getPhoneNo());
			statement.setString(4,user.getAddress());;
			
			statement.setString(5, encryptUsername(user.getUserName()));

		
			
			
			// Encrypt the password before updating it
            String encryptedPassword = encryptPassword(user.getPassword());
			
            statement.setString(6,encryptedPassword);
			statement.setString(7,user.getRole());
			
			statement.setInt(8, user.getUserId());
			
			statement.executeUpdate();
			
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
		
	

	@Override
	public void deleteUser(int userId) {
		
      PreparedStatement statement=null;
		
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			
			statement.setInt(1, userId);
			statement.execute();	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {
		

		Statement statement = null;
		
		ResultSet res = null;
		
	    ArrayList<User>  userlist =	new ArrayList<>();
  
		try {
			statement = connection.createStatement();
			
			res = statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
		
				int userid = res.getInt("UserId");
				String name = res.getString("name");
				String email = res.getString("email");
				int phone = res.getInt("phoneNo");
				String address = res.getString("address");
				String username = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdate = res.getDate("CreatedDate");
				Date lastlogintime = res.getDate("LastLogin");
				
				
			User user =	new User(userid, name, email, phone, address, username,password,role,createdate,lastlogintime);
				
			userlist.add(user);
				
			}	
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return userlist;
	}
	
	
	



	@Override
	public boolean authenticateUser(String username, String password) {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        statement = connection.prepareStatement(USER_PASSWORD);
	       
	        // Encrypt the provided username
	        String encryptedUsername = encryptUsername(username);
	        statement.setString(1, encryptedUsername);

	        // Encrypt the provided password
	        String encryptedPassword = encryptPassword(password);
	        statement.setString(2, encryptedPassword);

	        resultSet = statement.executeQuery();

	        return resultSet.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	
	
@Override
public int getUserIdByUsername(String Username) {

	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int userId = 0;
    
    try {
        preparedStatement = connection.prepareStatement(USER_ID);
        
        String encryptedUsername = encryptUsername(Username);
        preparedStatement.setString(1, encryptedUsername);
        resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            userId = resultSet.getInt("userId");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	return userId;
}


public Connection getConnection() {
	// TODO Auto-generated method stub
	return connection;
}
}

