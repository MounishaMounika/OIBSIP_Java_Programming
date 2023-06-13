package com.ATM_Interface.Beans;

public class RegisterBean {
	
	private long accountNumber,pin,confirmPin;
	private String name,phone,education,occupation;
//	private String dob;
	
	
	public RegisterBean() {
		super();
	}
	
	public RegisterBean(long accountNumber, long pin, long confirmPin, String name,String education,String occupation,String phone) {
		super();
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.confirmPin = confirmPin;
		this.name = name;
		this.phone = phone;
		this.education = education;
		this.occupation = occupation;
//		this.dob=dob;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public long getConfirmPin() {
		return confirmPin;
	}
	public void setConfirmPin(long confirmPin) {
		this.confirmPin = confirmPin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

//	public String getDob() {
//		return dob;
//	}
//
//	public void setDob(String dob) {
//		this.dob = dob;
//	}
	
	

}
