package com.example.banking_app.response;



public class AddressResponse {
	private String careOf;
	private String h_No;
	private String village;
	private String state;
	private int pincode; 
	
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
