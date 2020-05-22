package com.qa.models.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.models.Order;
import com.qa.persistence.DatabaseConnection;

public class OrderTest {
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Connecting to the database...");
		DatabaseConnection.connect();	
	}
	
	@Test
	public void testReadOrder() {		
		Order order = new Order();
		Order order1 = new Order(2, "2020-03-21", 3, 71.96);
		
		int CID = 2;
		String orderExpected = order1.toString();
		String orderActual = order.readOrder(CID).toString();
		assertEquals("Incorrect readings of orders table", orderExpected, orderActual);

	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		System.out.println("Disconnected from the database");
		DatabaseConnection.disconnect();
	}
}


