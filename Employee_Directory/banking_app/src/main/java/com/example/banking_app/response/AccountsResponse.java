package com.example.banking_app.response;

public class AccountsResponse {

	private long id;
	
	
	private long accountNumber;
	
	
	private String accountHolderName;
	
	private long phone;
	
	
	private String email;
	


	private double balance;
	private AddressResponse addressResponse;
	
	


	public AddressResponse getAddressResponse() {
		return addressResponse;
	}



	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}



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
	

}
