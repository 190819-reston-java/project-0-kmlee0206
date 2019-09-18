package com.revature.repository;

//import java.util.List;

import com.revature.model.Customer;

public interface CustomerDAO {
	
	Customer getCustomer(String username);
	
	boolean updateCustomer(Customer c);
	
}
