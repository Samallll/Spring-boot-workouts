package com.example.table;

public class User {
	
	private String name;
	private String designation;
	private String email;
	private int age;
	private String address;
	private String salary;
	
	public User(String name, String designation, String email, int age, String address, String salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
