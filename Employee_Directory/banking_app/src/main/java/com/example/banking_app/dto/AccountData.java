package com.example.banking_app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AccountData {
	private long id;
	private long accountNumber;
	private String accountHolderName;
	private long phone;
	@Email(message="Invalid email address")
	private String email;
    private double balance;
   
	private String careOf;
	
	private String h_No;
	
	private String village;
	
	private String state;
	
	
	private int pincode;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getCareOf() {
		return careOf;
	}


	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}


	public String getH_No() {
		return h_No;
	}


	public void setH_No(String h_No) {
		this.h_No = h_No;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
    
	


}
