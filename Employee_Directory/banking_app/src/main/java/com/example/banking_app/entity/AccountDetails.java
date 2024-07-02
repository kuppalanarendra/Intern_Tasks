package com.example.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name="accountsDetails")
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;
	
	@Column(name="accountNumber")
	private long accountNumber;
	
	@Column(name="accountHolderName")
	@NotNull(message = "Account Holder name not be Null")
	private String accountHolderName;
	
	@Column(name="phoneNumber")
	private long phone;
	
	@Column(name="email")
	@Email(message="Invalid email address")
	private String email;
	

	
	@Column(name="balance")
	private double balance;



	public AccountDetails() {
		super();
	}



	public AccountDetails(long id, long accountNumber,
			@NotNull(message = "Account Holder name not be Null") String accountHolderName, long phone,
			@Email(message = "Invalid email address") String email, double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.phone = phone;
		this.email = email;
		this.balance = 0.00;
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
