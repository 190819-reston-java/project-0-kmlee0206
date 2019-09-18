package com.revature.service;

import com.revature.exception.NegativeCurrencyException;
import com.revature.exception.OverdraftProtectionException;
import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;
import com.revature.repository.CustomerDAOImplPJDBC;

public class Transactions {

		static CustomerDAO customerDAO = new CustomerDAOImplPJDBC();
		
		public static String pullName(String username) {
			Customer customer = customerDAO.getCustomer(username);
			return customer.getName();
		}
		
		public static String pullUsername(String username) {
			Customer customer = customerDAO.getCustomer(username);
			return customer.getUsername();
		}
		
		public static String pullUserpwd(String username) {
			Customer customer = customerDAO.getCustomer(username);
			return customer.getUserpwd();
		}
		
		public static double viewBalance(String username) {
			Customer customer = customerDAO.getCustomer(username);
			return customer.getBalance();
		}
		
		public static void deposit(double depositAmt, String username) {
			Customer customer = customerDAO.getCustomer(username);
			if(depositAmt < 0) {
				throw new NegativeCurrencyException();
			}
			
			double finalBalance = (customer.getBalance() + depositAmt);
			customer.setBalance(finalBalance);
			customerDAO.updateCustomer(customer);
			
		}
		
		public static void withdraw(double withdrawAmt, String username) {
			Customer customer = customerDAO.getCustomer(username);
			if(withdrawAmt < 0) {
				throw new NegativeCurrencyException();
			}
			if(withdrawAmt > customer.getBalance()) {
				throw new OverdraftProtectionException();
			}
			double finalBalance = (customer.getBalance() - withdrawAmt);
			customer.setBalance(finalBalance);
			customerDAO.updateCustomer(customer);
			
		}
		
}