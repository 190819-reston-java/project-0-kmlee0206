package com.revature.service;

public class Deposit {
	
	public static void deposit(double depositAmt) {
		
		Balance.setBalance(Balance.getBalance() + depositAmt);
		
	}
	
}
