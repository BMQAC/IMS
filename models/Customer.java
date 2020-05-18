package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Customer {
	
	private String fname = null;
	private String lname = null;
	private String address = null;
	private String postcode = null;
	private String email = null;
	private int age = 0;
	
	public Customer() {
		
	}
	
	public Customer(String fname, String lname, String address, String postcode, String email,int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.age = age;
	}
	
	public void read() {
		String select = "SELECT * FROM customers";
		ResultSet results = DatabaseConnection.processQuery(select);

		try {
			while (results.next()) {
				System.out.println("CID: " + results.getInt("CID") + ", " + "first name: " + results.getString("first_name") + ", "
						+ "last name: " + results.getString("last_name") + ", " + "address: " + results.getString("address") + ", "
						+ "postcode: " + results.getString("postcode") + ", " + "email: " + results.getString("email") + ", "
						+ "age: " + results.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCustomer(Customer c) {
		String insert = "INSERT INTO customers (first_name, last_name, address, postcode, email, age) VALUES (\""
				+ c.getFname() + "\", \"" + c.getLname() + "\", \"" + c.getAddress() + "\", \"" + c.getPostcode() + "\", \"" + c.getEmail() + "\", \""
				+ c.getAge() + "\")";

		DatabaseConnection.processUpdate(insert);
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
}
