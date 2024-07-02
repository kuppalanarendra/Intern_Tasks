package com.example.banking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.banking_app.dto.AccountData;
import com.example.banking_app.response.AccountsResponse;
import com.example.banking_app.service.AccountsService;

import jakarta.validation.Valid;

@Controller
public class AccountsController {
	@GetMapping("/")
	public String hello() {
		
		return "sign";
	}
	
	@Autowired
	private AccountsService accountService;
	
	@PostMapping("/account")
	public String createAccount(@Valid AccountData accountData,Model model) {
		
		System.out.println("Account Created called");
		
		
		
		model.addAttribute("data", accountService.create(accountData));
	
		return "created";
		
	}
	@GetMapping("/getAll")
	public List<AccountsResponse> getAccounts() {
		
		return accountService.getAllAccounts();
		
	}
	@PutMapping("/deposite/{accountNumber}")
	public String deposite(@PathVariable(value="accountNumber" )long accountNumber , @RequestBody double balance) {
		return accountService.deposite(accountNumber,balance);
	}
	@PutMapping("/withdraw/{accountNumber}")
	public String withdrawl(@PathVariable(value="accountNumber")long accountNumber,@RequestBody double balance) {
		return accountService.withDrawl(accountNumber,balance);
		
	}
	@PutMapping("/transfer/{fromAccount}/{toAccount}")
	public String transfer(@PathVariable(value="fromAccount")long fromaccountNumber,@PathVariable(value="toAccount") long toAccountNumber,@RequestBody double balance) {
		return accountService.transfer(fromaccountNumber,toAccountNumber,balance);
	}

}
