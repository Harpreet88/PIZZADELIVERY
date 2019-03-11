package com.cg.pizza.beans;

import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="CustomerPizza")
@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int custId;
    private String firstName;
    private String lastName;
    private String mobNumber;
    private String emailId;
    
    @Embedded
    private Address address;
    

	  @OneToMany(mappedBy="customer")
	  
	  @MapKey private Map<Integer,PizzaOrders> order;
	 
    
    public Customer()
    {}

	
    public Customer(String firstName, String lastName, String mobNumber, String emailId, Address address) 
    {
    	super(); 
    	this.firstName = firstName;
    	this.lastName = lastName; 
    	this.mobNumber = mobNumber; 
    	this.emailId = emailId;
    	this.address = address;
    }
	

	public Customer(int custId, String firstName, String lastName, String mobNumber, String emailId, Address address) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.emailId = emailId;
		this.address = address;
	}


	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	  public Map<Integer,PizzaOrders> getOrder() { return order; }
	 
	  public void setOrder(Map<Integer,PizzaOrders> order) { this.order = order; }
	



	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNumber="
				+ mobNumber + ", emailId=" + emailId + ", address=" + address +"orders=" + order +"]";
	}


     
    
}
