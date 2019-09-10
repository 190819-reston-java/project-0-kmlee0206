package com.revature.exception;

public class NegativeCurrencyException extends RuntimeException{

	public NegativeCurrencyException () {
		this("The amount can't be negative!");
	}

	public NegativeCurrencyException(String msg) {
		super(msg);
	}
	
	
	
	
	
}
