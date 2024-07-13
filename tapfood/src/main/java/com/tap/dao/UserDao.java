package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDao {
	
	int addUser(User user);
	User getUser(int UserId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User>getAllUsers();
	
	 boolean authenticateUser(String username, String password);
	 
	int getUserIdByUsername(String Username);

}
