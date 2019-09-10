package com.revature.exception;

public class InvalidCurrencyException extends RuntimeException{
	
	public InvalidCurrencyException () {
		this ("Currency have to be a number");
	}

	public InvalidCurrencyException(String msg) {
		super(msg);
	}
	
	
	

}
