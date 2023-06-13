package com.ATM_Interface.Beans;

public class TransferBean {
	
	private long tranferAccount;
	double transferAmount;
	
	
	
	public TransferBean() {
		super();
	}

	public TransferBean(long tranferAccount, double transferAmount) {
		super();
		//this.acccountNumber = acccountNumber;
		this.tranferAccount = tranferAccount;
		this.transferAmount = transferAmount;
	}
	
//	public long getAcccountNumber() {
//		return acccountNumber;
//	}
//	public void setAcccountNumber(long acccountNumber) {
//		this.acccountNumber = acccountNumber;
//	}
	public long getTranferAccount() {
		return tranferAccount;
	}
	public void setTranferAccount(long tranferAccount) {
		this.tranferAccount = tranferAccount;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	

}
