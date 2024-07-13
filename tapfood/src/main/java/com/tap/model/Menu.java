package com.tap.model;

public class Menu {
	
   private int	menuId;
   private String name;
   private int	price;
   private String 	description;
   private String 	imagePath;
   private Boolean isAvailable;
   private int restaurantId;
   private float ratings;
   
  public Menu() {
	
}

public Menu(int menuId, String name, int price, String description, String imagePath, Boolean isAvailable,
		int restaurantId, float ratings) {
	super();
	this.menuId = menuId;
	this.name = name;
	this.price = price;
	this.description = description;
	this.imagePath = imagePath;
	this.isAvailable = isAvailable;
	this.restaurantId = restaurantId;
	this.ratings = ratings;
}

public int getMenuId() {
	return menuId;
}

public void setMenuId(int menuId) {
	this.menuId = menuId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

public Boolean getIsAvailable() {
	return isAvailable;
}

public void setIsAvailable(Boolean isAvailable) {
	this.isAvailable = isAvailable;
}

public int getRestaurantId() {
	return restaurantId;
}

public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}

public float getRatings() {
	return ratings;
}

public void setRatings(float ratings) {
	this.ratings = ratings;
}
	

}
