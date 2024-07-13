package com.tap.daoImp;





import java.util.List;

import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItems;
import com.tap.model.Restaurant;
import com.tap.model.User;






public class Demo {
	
	public static void main(String[] args) {
		
		
		
		//RestaurantDaoImp udi = new RestaurantDaoImp();
//		MenuDaoImp  udi	=	new MenuDaoImp();
		//OrderDaoImp  udi	=	new OrderDaoImp();
		OrderItemsDaoImp  udi	=	new OrderItemsDaoImp();
		//OrderHistoryDaoImp  udi	=	new OrderHistoryDaoImp();
		
//		int u = 1;
//		udi.getMenuByRestaurantId(u);

		
		User user = new User();
		UserDaoImp u = new UserDaoImp();
		System.out.println(u.getUserIdByUsername("J"));
		/*
		
		User user2 = u.getUser(user.getUserId());
		
		System.out.println(user2.getName()+","+user2.getEmail());
		
		*/
		
		
		/*
		List<Restaurant> ll = udi.getAllrestaurant();
		for(Restaurant restaurant : ll)
		{
			System.out.println(restaurant.getName()+","+restaurant.getCuisineType()+","+restaurant.getEta()+","+restaurant.getAddress());
		}
		*/
		
		
		/*
		User u = new User(5,"Keshavi","keshav32@gmail.com",898574198,"Ananthapur","Keshavaadi","keshav@990","Customer",null,null);
		
		udi.updateUser(u);
		*/
		
		
		
		/*
		int u = 4;
		
		udi.deleteUser(u);
		
		*/
		
	
 /*		
		int u = 1;
		
		udi.getUser(u);
		
		*/
		
		
		/*
		User u = new User(4,"Khanjabeer","jabeer921@gmail.com",698574125,"chitthor","jabeerkhan","Jabeer@990","SystemAdmin",null,null);
		
		udi.updateUser(u);
		
		*/
		//(1, 'Pizza Hut', 'picter', '4.3', '30', 'non-veg', 'Ramashwaram', '1', '3')
		//'2', 'BOOM Sandwhich', 'picter', '4.3', '30', 'veg', 'Hebbel', '1', '3'
		//'3', 'leno\'s -Burgers', 'picter', '4', '30', 'veg', 'Banashankari', '1', '1'

		//(1,"K.F.C","picter",4.3f,30,"non-veg","Ramashwaram",true,3);
		//(6,"K.F.C","picter",4.3f,30,"non-veg","Ramashwaram",true,3);
		//(6,"K.F.C","picter",4.3f,30,"non-veg","Ramashwaram",true,3);
		
		
		
		
      /*
		
		Restaurant u = new Restaurant(1, "McDonald's", "https://b.zmtcdn.com/data/pictures/7/50677/92237989e8a919c0fcfdf3d9f8da3fb0_o2_featured_v2.jpg", 4.8f, 30, "veg", "HSR", true, 5);

		
		udi.updaterestaurant(u);
	  */
	
	
		
		/*
		int u = 1;
		udi.deleterestaurant(u);
		*/
		
	
        /*
        Menu u = new Menu(5,"McSpicy Chicken Burger + McChicken Burger",375,"Flat 15% Off on McSpicy Chicken Burger + McChicken Burger + Fries (M)","https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/ea7ba594c7d77cb752de9a730fbcb3bf",true,2,4.0f);
		
		udi.addMenu(u);
	    */
		
		
		/*
		Menu u = new Menu(4,"Lalu",200,"Non-Spice","picture",true,8,4.5f);
		
		udi.updateMenu(u);
		*/
		
		/*
		int u =4;
		udi.deleteMenu(u);
		*/
		
		
		/*
        Order u = new Order(1,1,1,700,"COD","Dispatched");
		
		udi.addOrder(u);
		*/
		
//		OrderItems(orderItemId, userId, menuId, name, quantity, price,restaurantId,historyId)
		
//		OrderItems u = new OrderItems(1,1,1,"Ultimat",1,123,2,1254);
//		
//		udi.addOrderItems(u);
		
		
		
		/*
		int u =1;
		udi.deleteOrderItems(u);
		*/
		
		
		/*
		OrderHistory u = new OrderHistory(1,1,1);
		
		udi.addOrderHistory(u);
		*/
		
		
		/*
		int u =1;
		udi.deleteOrderHistory(u);
	
		*/
		
		/*
		
		<%
	    // Assuming you have a RestaurantDao instance available, 
	    // you can get the list of restaurants from the DAO implementation
	    RestaurantDao restaurantDao = new RestaurantDaoImp();
	    List<Restaurant> list = restaurantDao.getAllrestaurant();

	    //if (list != null && !list.isEmpty()) {
	        for (Restaurant restaurant : list) {
	            out.println(restaurant.getName());
	            out.println(restaurant.getCuisineType());
	            out.println(restaurant.getRating());
	            out.println(restaurant.getEta());
	        }
	    //}
	%>
		*/
	}

}
