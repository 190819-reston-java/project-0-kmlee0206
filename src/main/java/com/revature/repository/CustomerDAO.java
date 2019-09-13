package com.revature.repository;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDAO {
	
	Customer getCustomer(long id);
	
	Customer getCustomer(String name);
	
	List<Customer> getCustomer();
	
}
