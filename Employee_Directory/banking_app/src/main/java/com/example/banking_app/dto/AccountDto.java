package com.example.banking_app.dto;

import com.example.banking_app.entity.AccountDetails;
import com.example.banking_app.entity.AddressDetails;

public class AccountDto {
	private AccountDetails accountDetails;
	private AddressDetails addressDetails=new AddressDetails() ;
	
	public AccountDetails getAccountDetails() {
		
		return accountDetails;
		
	}
	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	

}
