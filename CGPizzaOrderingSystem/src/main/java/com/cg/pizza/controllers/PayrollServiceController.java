package com.cg.pizza.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;
import com.cg.pizza.services.PizzaServices;
@Controller
public class PayrollServiceController {
	@Autowired
	PizzaServices pizzaServices;
	
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>(" Hello in postman",HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value= {"/getCustomerDetails"},
			method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Customer> getAssociateDetailsRequestParam(@RequestParam int custId)throws CustomerNotFoundException{
		Customer customer=pizzaServices.getCustomerDetails(custId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	

	@RequestMapping(value= {"/acceptCustomerDetails"},method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
			public ResponseEntity<String> acceptAssociateDetails(@ModelAttribute Customer customer) throws InvalidMobileNumberException, InvalidEmailIdException{
		customer=pizzaServices.acceptCustomerDetails(customer);
		return new ResponseEntity<>("Associate details successfully added associate Id:-"+customer.getCustId(),HttpStatus.OK);
	
	}
}