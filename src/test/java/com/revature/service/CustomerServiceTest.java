package com.revature.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.mocks.CustomerDAOMock;
import com.revature.model.Customer;

public class CustomerServiceTest {
	
	private static Transactions transactions = null;
	private static String username = "testdummy";
	
	@Before
	public void setUp() {
		transactions = new Transactions(new CustomerDAOMock());
	}
	
	@After
	public void tearDown() {
		transactions = null;
	}
	
	@Test
	public void viewBalance() {
		double testValue = Transactions.viewBalance(username);
		assertEquals(100, testValue);
		
	}
	
	@Test
	public void deposit() {
		Transactions.deposit(50, username);
		double testVal = Transactions.viewBalance(username);
		assertEquals(150, testVal);
	}
	
	@Test
	public void withdraw() {
		Transactions.withdraw(25, username);
		double testVal = Transactions.viewBalance(username);
		assertEquals(75, testVal);
	}
	
	

}
