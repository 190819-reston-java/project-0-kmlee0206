package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

		assertTrue(Transactions.viewBalance(username) == 100);
	}
	
	@Test
	public void pullName() {

		assertTrue(Transactions.pullName(username) == "Dumbo");
	}
	
	@Test
	public void pullUserpasswd() {

		assertTrue(Transactions.pullUserpwd(username) == "passtest");
	}
	
	

}
