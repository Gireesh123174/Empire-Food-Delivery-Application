package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class CartCreator {
	
	static Map<Integer,CartItem>CartItem = new HashMap();
	public CartCreator() 
	{	
	
	}
	
     public void addCartItem(CartItem ci)
	{		
		if(CartItem.containsKey(ci.getMenuId()))
		{ 
			
			//int n3 = CartItem.get(ci.getMenuId()).getQuantity()+ci.getQuantity();
			//CartItem.get(ci.getMenuId()).setQuantity(n3);
			CartItem cr=CartItem.get(ci.getMenuId());
			int n1=cr.getQuantity();
			int n2=ci.getQuantity();
			int n3=n1+n2;
			cr.setQuantity(n3);
//			CartItem.put(cr.getMenuId(),cr);
						
		}
		else
		{
			CartItem.put(ci.getMenuId(),ci);	
		}
			
	}
  public void updateCartItem(int menuId, int quantity)
	{
	  CartItem.get(menuId).setQuantity(quantity);

	}
  
  public void deleteCartItem(int menuId)
  {
	  CartItem.remove(menuId);
  }
  
  public Map<Integer,CartItem> getAll()
  {
	  return CartItem;
  }




	
}