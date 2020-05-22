package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Customer {
	
	private int CID = 0;
	private String fname = null;
	private String lname = null;
	private String address = null;
	private String postcode = null;
	private String email = null;
	private int age = 0;
	
	public Customer() {
		
	}
	
	public Customer(String fname, String lname, String address, String postcode, String email, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.age = age;
	}

//  This readCustomer() is explicitly used for testing the SELECT functionality of MySQL in java 
	public Customer readCustomer(String first_name) {
		String select = "SELECT * FROM customers WHERE first_name = \"" + first_name +"\"";
		ResultSet results = DatabaseConnection.processQuery(select);
		
		String fnameTemp = null;
		String lnameTemp = null;
		String addressTemp = null;
		String postcodeTemp = null;
		String emailTemp = null;
		int ageTemp = 0;
		
		try {
			while (results.next()) {
				fnameTemp = results.getString("first_name");
				lnameTemp = results.getString("last_name");
				addressTemp = results.getString("address");
				postcodeTemp = results.getString("postcode");
				emailTemp = results.getString("email");
				ageTemp = results.getInt("age");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Customer(fnameTemp, lnameTemp, addressTemp, postcodeTemp, emailTemp, ageTemp);
	}
	
//  This read() method is explicitly used in my application
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
	
	public void delete(int CID){
		String delete = "DELETE FROM customers WHERE CID = " + CID;
		DatabaseConnection.processUpdate(delete);
	}

//  toString() is used for testing
	@Override
	public String toString() {
		return CID + ", " + fname + ", " + lname + ", " + address + ", " + postcode + ", " + email + ", " + age;
	}
	
	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
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
