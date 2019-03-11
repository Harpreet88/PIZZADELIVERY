package com.cg.pizza.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.responses.CustomeResponse;


@ControllerAdvice
public class CustomerExceptionAspect {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<CustomeResponse>handleCustomerDetailsNotFoundException(Exception e){
		CustomeResponse response=new CustomeResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}

}
