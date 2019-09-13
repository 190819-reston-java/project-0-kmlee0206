package com.revature.model;

public class Customer {
	
	private long id;
	private String name;
	private String username;
	private String userpwd;
	private double balance;
	
	public Customer(long id, String name, String username, String userpwd, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.userpwd = userpwd;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", userpwd=" + userpwd
				+ ", balance=" + balance + "]";
	}
	
	

}
