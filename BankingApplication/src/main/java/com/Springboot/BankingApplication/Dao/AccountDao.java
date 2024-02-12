package com.Springboot.BankingApplication.Dao;

public class AccountDao {

	private long id;
	
	private String accountholdername;
	
	private double balance;

	public AccountDao(long id, String accountholdername, double balance) {
		this.id = id;
		this.accountholdername = accountholdername;
		this.balance = balance;
	}

	public AccountDao() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
