package com.ATM_Interface.Beans;

public class TransactionHistoryBean {
	
	private long accountNumber,othersAccount;
	String accountHolderName,actionPerformed;
	double amount;

	public TransactionHistoryBean() {
		super();
	}

	public TransactionHistoryBean(long accountNumber,long othersAccount, String accountHolderName,
			String actionPerformed, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.othersAccount = othersAccount;
		this.accountHolderName = accountHolderName;
		this.actionPerformed = actionPerformed;
		this.amount = amount;
	}

	public long getOthersAccount() {
		return othersAccount;
	}

	public void setOthersAccount(long othersAccount) {
		this.othersAccount = othersAccount;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getActionPerformed() {
		return actionPerformed;
	}

	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
