package com.example.banking_app.response;

import java.util.List;




public class CombinedResponse {
	
	private AccountsResponse accountsResponse;

	public CombinedResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	 private AddressResponse addressResponse;



		public AddressResponse getAddressResponse() {
			return addressResponse;
		}



		public void setAddressResponse(AddressResponse addressResponse) {
			this.addressResponse = addressResponse;
		}



	public CombinedResponse(AccountsResponse accountsResponse,AddressResponse addressResponse) {
		super();
		this.accountsResponse = accountsResponse;
		this.addressResponse = addressResponse;
		
	}


	public AccountsResponse getAccountsResponse() {
		return accountsResponse;
	}


	public void setAccountsResponse(AccountsResponse accountsResponse) {
		this.accountsResponse = accountsResponse;
	}


	
	
	

}
