package com.cg.pizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Items;
import com.cg.pizza.beans.PizzaOrders;
import com.cg.pizza.daoservices.ItemDAO;
import com.cg.pizza.daoservices.OrderDAO;
import com.cg.pizza.daoservices.PizzaDAO;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;
@Component("pizzaServices")
public class PizzaServicesImpl implements PizzaServices
{
	@Autowired
	private PizzaDAO pizzaDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
    @Override
	public Customer acceptCustomerDetails(Customer customer) throws InvalidMobileNumberException, InvalidEmailIdException {
		customer = pizzaDAO.save(customer);
		return customer;
	}
    
    @Override
	public Customer getCustomerDetails(int custId) throws CustomerNotFoundException {
		Customer customer = pizzaDAO.findById(custId).orElseThrow(()->new CustomerNotFoundException("Customer details not found exception"));
		if(customer == null)
			throw new CustomerNotFoundException("Sorry Customer Not Found!");
		return customer;
	}
	@Override
	public Customer acceptOrder(int custId, int itemId, int quantity) throws CustomerNotFoundException {
		Customer customer = pizzaDAO.findById(custId).orElseThrow(()->new CustomerNotFoundException("Customer details not found exception"));
		if(customer == null)
		   throw new CustomerNotFoundException("Sorry Customer Not Found!");
		//Order orders = new Order();
		PizzaOrders order = new PizzaOrders();
		order.setQuantity(quantity);
		int totalPrice =calculatePrice(custId, order.getOrderId(), itemId,quantity);
		order.setTotalPrice(totalPrice);
		System.out.println(order.getTotalPrice());
		order.setCustomer(customer);
		orderDAO.save(order);
		return customer;
	}

	@Override
	public int calculatePrice(int custId,int orderId, int itemId,int quantity) throws CustomerNotFoundException {
		Customer customer = getCustomerDetails(custId);
		PizzaOrders order = new PizzaOrders();
		Items item =itemDAO.findById(itemId).orElseThrow(()->new CustomerNotFoundException("Items not found exception"));
		
		int basicPrice =item.getItemPrice(); 
		 System.out.println(basicPrice);
		int withQuantity = (int)basicPrice * quantity;
		int cGST = (int)((withQuantity*10)/100);
		int sGST =(int)((withQuantity*5)/100);
		int totalPrice = (int)(withQuantity + cGST + sGST); 
		return totalPrice;
	}

	@Override
	public List<Customer> showAllCustomers() 
	{
		List<Customer> customer = pizzaDAO.findAll();
		return customer;
	}
	
	
	
}
