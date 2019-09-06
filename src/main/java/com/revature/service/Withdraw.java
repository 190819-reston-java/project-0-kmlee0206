package com.revature.service;

public class Withdraw {
	
	public static void withdraw(double withdrawAmt) {

		Balance.setBalance(Balance.getBalance() - withdrawAmt);
		
	}

}
