package com.revature.mocks;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;

public class CustomerDAOMock implements CustomerDAO {

	@Override
	public Customer getCustomer(String username) {
		
			return new Customer(3L, "Dumbo", "testdummy", "passtest", 100.00);
			
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

}
