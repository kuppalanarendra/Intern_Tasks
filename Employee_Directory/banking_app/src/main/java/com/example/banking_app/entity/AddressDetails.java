package com.example.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@Entity
@Table(name="addressDetails")
@NoArgsConstructor
@AllArgsConstructor
public class AddressDetails {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="C/O")
	@NotNull
	private String careOf;
	@Column(name="door_No")
	private String h_No;
	@Column(name="Village")
	@NotNull
	private String village;
	@Column(name="state")
    @NotNull
	private String state;
	
	@Column(name="pincode")
	private int pincode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
