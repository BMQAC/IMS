package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Order {
	
	private int CID = 0;
	private String orderDate = null;
	private int qtyOrdered = 0;
	
	public Order() {
		
	}
	
	public Order(int CID, String orderDate, int qtyOrdered) {
		super();
		this.CID = CID;
		this.orderDate = orderDate;
		this.qtyOrdered = qtyOrdered;	
	}
	
	public void createOrder(Order o) {
		String insert = "INSERT INTO orders (CID, order_date, qty_ordered) VALUES (\"" + o.getCID() + "\", \"" + o.getOrderDate()
				+ "\", \"" + o.getQtyOrdered() + "\")";

		DatabaseConnection.processUpdate(insert);
	}

	public void read() {
		String select = "SELECT * FROM orders";
		ResultSet results = DatabaseConnection.processQuery(select);

		try {
			while (results.next()) {
				System.out.println(results.getInt("OID") + ", " + results.getInt("CID") + ", "
						+ results.getString("order_date") + ", " + results.getInt("qty_ordered"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

}
