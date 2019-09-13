package com.revature;

import com.revature.controller.UserScreen;
import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOImplPJDBC;


/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {

		//UserScreen.app();
		
		CustomerDAO customerDAO = new CustomerDAOImplPJDBC();
		
		
		System.out.println(customerDAO.getCustomer(1L));
		
	}
}
