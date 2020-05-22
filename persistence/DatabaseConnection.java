package com.qa.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String USER = "root";
	static final String PASSWORD = "root";
	static final String URL = "jdbc:mysql://localhost/booksgalore?serverTimezone=UTC";

	static Connection conn = null;
	static Statement stmt = null;
	
	public DatabaseConnection() {
		
	}
	
// This connectCheck() method was set up for testing because my connect() method below has a void return type
	public String connectCheck() {
		String connected = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			
			if(conn != null) {
				connected = "Successful connection to the database";
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connected;
	}

// This is the connect() method I call in my running application 	
	public static void connect() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();

			if (conn != null) {
				System.out.println("Successful connection to the database");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void processUpdate(String query) {
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet processQuery(String query) {
		ResultSet r = null;
		try {
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public static void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
