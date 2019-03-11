package com.cg.pizza.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public  class Items 
{	@Id
	private int itemId;
	private int itemPrice;
	public static Map<Integer,Integer> items = new HashMap<Integer,Integer>();
	
	 @ManyToOne private PizzaOrders order;
	 
	//Items item = new Items();
	public Items()
	{
		
	}
	
	
	public Items(int itemId, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemPrice = itemPrice;
	}


	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
}
