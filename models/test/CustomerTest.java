package com.qa.models.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.models.Customer;
import com.qa.persistence.DatabaseConnection;

public class CustomerTest {
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Connecting to the database...");
		DatabaseConnection.connect();	
	}
	
	@Test
	public void testReadCustomer() {		
		Customer customer = new Customer();
		Customer customer1 = new Customer("James", "Daniel", "12 Hunter Road, Blackwell", "H14 5TY", "jdan@yahoo.com", 23);
		
		String James = "James";
		String customerExpected = customer1.toString();
		String customerActual = customer.readCustomer(James).toString();
		assertEquals("Incorrect reading of customer database", customerExpected, customerActual);

	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		Customer customer1 = new Customer("Harrison", "James", "12 Craven Drive, Bullwell", "NI3 5TR", "harrijames@hotmail.com", 37);
		
		customer.createCustomer(customer1);
		String Harrison = "Harrison";
		String customerExpected = customer1.toString();
		String customerActual = customer.readCustomer(Harrison).toString();
		
		assertEquals("No matching customer found in the database", customerExpected, customerActual);
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Disconnected from the database");
		
		DatabaseConnection.disconnect();
	}

}
