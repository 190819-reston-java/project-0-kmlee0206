package com.revature.service;

import com.revature.exception.NegativeCurrencyException;

public class Deposit {
	
	public static void deposit(double depositAmt) {
		if(depositAmt < 0) {
			throw new NegativeCurrencyException();
		}
		Balance.setBalance(Balance.getBalance() + depositAmt);
	}
	
}
