package com.revature.exception;

public class InvalidCurrencyException extends NumberFormatException{
	
	public InvalidCurrencyException () {
		this ("Currency has to be a number!");
	}

	public InvalidCurrencyException(String msg) {
		super(msg);
	}
	
	
	

}
