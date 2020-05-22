package com.qa.persistance.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.persistence.DatabaseConnection;

public class DatabaseConnectionTest {

	@Test
	public void testConnectCheck() {
		
		DatabaseConnection dc = new DatabaseConnection();
		String connectionMessage = "Successful connection to the database";
		assertEquals("Not successfully connectected to DB", connectionMessage, dc.connectCheck());
	}
}
