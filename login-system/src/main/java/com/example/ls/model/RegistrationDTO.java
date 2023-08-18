package com.example.ls.model;

public class RegistrationDTO {
	
	private String userName;
	private String password;
	
	public RegistrationDTO() {
		super();
	}
	@Override
	public String toString() {
		return "RegistrationDTO :" + userName + ", password=" + password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
