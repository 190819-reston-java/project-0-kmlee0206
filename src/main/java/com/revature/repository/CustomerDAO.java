package com.revature.repository;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDAO {
	
	Customer getCustomer(String username);
	
	boolean updateCustomer(Customer c);
	
	//Customer getCustomer(String name);
	
	//Customer getCustomerBalance(String username);
	
	List<Customer> getCustomer();
	
}
