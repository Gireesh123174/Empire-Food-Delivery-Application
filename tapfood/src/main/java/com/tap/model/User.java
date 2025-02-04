package com.tap.model;

import java.util.Date;

public class User {
	
	private int userId;
	private String name;
	private String email;
	private int phoneNo;
	private String address;
	private String userName;
	private String password;
	private String role;
	private Date CreateDate;
	private Date LastloginDate;
	
	
	public User() {
			
	}


	public User(int userId, String name, String email, int phoneNo, String address, String userName, String password,
			String role, Date createDate, Date lastloginDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.userName = userName;
		this.password = password;	
		this.role = role;
		CreateDate = createDate;
		LastloginDate = lastloginDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Date getCreateDate() {
		return CreateDate;
	}


	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}


	public Date getLastloginDate() {
		return LastloginDate;
	}


	public void setLastloginDate(Date lastloginDate) {
		LastloginDate = lastloginDate;
	}

	
	

}
