package com.revature.exception;

public class OverdraftProtectionException extends RuntimeException {
	
	public OverdraftProtectionException () {
		this("Cannot withdraw more money than what you have in your bank account!");
	}
	
	public OverdraftProtectionException(String msg) {
		super(msg);
	}

}
