package com.revature.service;

import com.revature.exception.NegativeCurrencyException;

public class Withdraw {
	
	public static void withdraw(double withdrawAmt) {
		if(withdrawAmt < 0) {
			throw new NegativeCurrencyException();
		}
		Balance.setBalance(Balance.getBalance() - withdrawAmt);
		
	}

}
