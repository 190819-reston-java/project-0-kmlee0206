package com.revature.service;

public class Balance {
	
	protected static double balance = 0.00;
	
	public static double currentBalance() {
		return getBalance();
	}

	/**
	 * @return the balance
	 */
	protected static double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	protected static void setBalance(double balance) {
		Balance.balance = balance;
	}
	
	

}
