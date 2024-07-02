package com.example.banking_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_app.dto.AccountData;
import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.AccountDetails;
import com.example.banking_app.entity.AddressDetails;
import com.example.banking_app.repository.AccountsRepository;
import com.example.banking_app.repository.AddresRepository;
import com.example.banking_app.response.AccountsResponse;
import com.example.banking_app.response.AddressResponse;
import com.example.banking_app.response.CombinedResponse;

import jakarta.validation.Valid;

@Service
public class AccountsService {
	@Autowired
	private AccountsRepository accountsRepo;

	@Autowired
	private  AddresRepository addresRepository;

	public  AccountDto create( AccountData accountData) {
		AccountDto accountDto= new AccountDto();
		AccountDetails accountDetails= new AccountDetails();
		accountDetails.setAccountHolderName(accountData.getAccountHolderName());
		accountDetails.setAccountNumber(accountNum());
		accountDetails.setEmail(accountData.getEmail());
		accountDetails.setPhone(accountData.getPhone());
		accountDto.setAccountDetails(accountsRepo.save(accountDetails));
		AddressDetails addressDetails =new AddressDetails();
		addressDetails.setId(accountDetails.getId());
		addressDetails.setCareOf(accountData.getCareOf());
		addressDetails.setH_No(accountData.getH_No());
		addressDetails.setVillage(accountData.getVillage());
		addressDetails.setState(accountData.getState());
		addressDetails.setPincode(accountData.getPincode());
		accountDto.setAddressDetails(addresRepository.save(addressDetails));
		
		
		
		System.out.println("Account Cretaed Successfully");
		return accountDto;

	}

	private long accountNum() {
      System.out.println("AccountNum called");
		Random random = new Random();

		return random.nextLong(9999999);

	}

	public List<AccountsResponse> getAllAccounts() {
	    List<AccountDetails> accountDetailsList = accountsRepo.findAll();
	    List<AccountsResponse> accountsResponseList = new ArrayList<>();

	    for (AccountDetails accountDetails : accountDetailsList) {
	        AccountsResponse accountsResponse = new AccountsResponse(); // Create a new object inside the loop

	        accountsResponse.setId(accountDetails.getId());
	        accountsResponse.setAccountNumber(accountDetails.getAccountNumber());
	        accountsResponse.setAccountHolderName(accountDetails.getAccountHolderName());
	        accountsResponse.setPhone(accountDetails.getPhone());
	        accountsResponse.setEmail(accountDetails.getEmail());
	        accountsResponse.setBalance(accountDetails.getBalance());

	        // Set the address response
	        accountsResponse.setAddressResponse(getAddress(accountDetails.getId())); 

	        accountsResponseList.add(accountsResponse); // Add the created object to the list
	    }

	    return accountsResponseList;
	}

	private AddressResponse getAddress(long id) {
	    AddressDetails addressDetails = addresRepository.findById(id);
	    AddressResponse addressResponse = new AddressResponse();

	    addressResponse.setCareOf(addressDetails.getCareOf());
	    addressResponse.setH_No(addressDetails.getH_No());
	    addressResponse.setVillage(addressDetails.getVillage());
	    addressResponse.setState(addressDetails.getState());
	    addressResponse.setPincode(addressDetails.getPincode());

	    return addressResponse;
	}

	public String deposite(long accountNumber,double balance) {
	AccountDetails accountDetails=	accountsRepo.findByAccountNumber(accountNumber);
	double bankbalance=accountDetails.getBalance();
	System.out.println(bankbalance);
	accountDetails.setBalance(bankbalance+balance);
	
	accountsRepo.save(accountDetails);
	
	return "Amount Deposited Successfully\nTotal Balance in your Account is:"+accountDetails.getBalance();
	}

	public String withDrawl(long accountNumber, double balance) {
		AccountDetails accountDetails=	accountsRepo.findByAccountNumber(accountNumber);
		if(accountDetails.getBalance()>=balance) {
			accountDetails.setBalance(accountDetails.getBalance()-balance);
			accountsRepo.save(accountDetails);
		}
		else {
			return "Not Enough money in the Account";
		}
		return "Amount withdrawn successfully\n"+"\n"+"Current Balance in your Account is:"+accountDetails.getBalance();
	}

	public String transfer(long fromaccountNumber, long toAccountNumber, double balance) {
		withDrawl(fromaccountNumber,balance);
		 deposite(toAccountNumber,balance);
		 return "Amount Transfered Successfully";
	}

}
