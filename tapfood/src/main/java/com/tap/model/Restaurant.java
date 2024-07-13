package com.tap.model;

public class Restaurant {
	
  private int restaurantId;
  private String name;
  private String imageUrl;
  private Float rating;
  private int eta;
  private String cuisineType;
  private String Address;
  private Boolean isActive;
  private int restaurantOwnerId;
  
  public Restaurant() {
	
}

public Restaurant(int restaurantId, String name, String imageUrl, Float rating, int eta, String cuisineType,
		String address, Boolean isActive, int restaurantOwnerId) {
	super();
	this.restaurantId = restaurantId;
	this.name = name;
	this.imageUrl = imageUrl;
	this.rating = rating;
	this.eta = eta;
	this.cuisineType = cuisineType;
	Address = address;
	this.isActive = isActive;
	this.restaurantOwnerId = restaurantOwnerId;
}

public int getRestaurantId() {
	return restaurantId;
}

public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public Float getRating() {
	return rating;
}

public void setRating(Float rating) {
	this.rating = rating;
}

public int getEta() {
	return eta;
}

public void setEta(int eta) {
	this.eta = eta;
}

public String getCuisineType() {
	return cuisineType;
}

public void setCuisineType(String cuisineType) {
	this.cuisineType = cuisineType;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}

public int getRestaurantOwnerId() {
	return restaurantOwnerId;
}

public void setRestaurantOwnerId(int restaurantOwnerId) {
	this.restaurantOwnerId = restaurantOwnerId;
}


   

}
