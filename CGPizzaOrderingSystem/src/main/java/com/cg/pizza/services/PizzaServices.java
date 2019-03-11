package com.cg.pizza.services;

import java.util.List;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;

public interface PizzaServices 
{
	public Customer acceptCustomerDetails(Customer customer) throws InvalidMobileNumberException, InvalidEmailIdException;
	 
	public Customer getCustomerDetails(int custId) throws CustomerNotFoundException;
	
     public Customer acceptOrder(int custId,int itemId, int quantity) 
    		 throws CustomerNotFoundException;
     
     public int calculatePrice(int custId,int orderId, int itemId,int quantity) throws CustomerNotFoundException;
     
     List<Customer> showAllCustomers();
}
