package com.ATM_Interface.Beans;

public class DepositWithdrawBean {
	
	 private long accountNumber;
	 private double amount;
	 
	 
	public DepositWithdrawBean() {
		super();
	}
	public DepositWithdrawBean(long accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	 
	 

}
