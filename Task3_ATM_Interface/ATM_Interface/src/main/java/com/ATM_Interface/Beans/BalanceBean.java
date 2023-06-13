package com.ATM_Interface.Beans;

public class BalanceBean {
	
	private long pin;

	public BalanceBean() {
		super();
	}

	public BalanceBean(long pin) {
		super();
		//this.accountNumber = accountNumber;
		this.pin = pin;
	}

//	public long getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(long accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}
	
	

}
