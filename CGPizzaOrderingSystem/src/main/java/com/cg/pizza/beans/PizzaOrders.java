package com.cg.pizza.beans;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class PizzaOrders 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	private int quantity;
	private int totalPrice;

 @OneToMany(mappedBy="order")
 
 @MapKey public Map<Integer,Items> items;

	
	
	  @ManyToOne 
	  private Customer customer;
	 
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	

	public PizzaOrders(int orderId, int quantity)
	{
		super(); 
		this.orderId = orderId;
		this.quantity = quantity; 
	}
	 
    public PizzaOrders()
    {
    
    }
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * public Map<Integer, Integer> getItems() { return items; }
	 * 
	 * public void setItems(Map<Integer, Integer> items) { this.items = items; }
	 */

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", totalPrice=" + totalPrice +  "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + orderId;
		result = prime * result + quantity;
		result = prime * result + totalPrice;
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}*/

	public PizzaOrders(int orderId, int quantity, int totalPrice)//HashMap<Integer, Integer> items) 
	{
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		//this.items = items;
	}



}
