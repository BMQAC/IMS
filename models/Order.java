package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Order {
	
	private int CID = 0;
	private String orderDate = null;
	private int qtyOrdered = 0;
	private double value = 0.0;
	
	public Order() {
		
	}
	
	public Order(int CID, String orderDate, int qtyOrdered, double value) {
		super();
		this.CID = CID;
		this.orderDate = orderDate;
		this.qtyOrdered = qtyOrdered;
		this.value = value;
	}
	
	public void createOrder(Order o) {
		String insert = "INSERT INTO orders (CID, order_date, qty_ordered) VALUES (\"" + o.getCID() + "\", \"" + o.getOrderDate()
				+ "\", \"" + o.getQtyOrdered() + "\", \"" + o.getValue() + "\")";

		DatabaseConnection.processUpdate(insert);
	}
	
	public void addOrder(int CID, String orderDate, int qtyOrdered, double value) {
		String insert = "INSERT INTO orders (CID, order_date, qty_ordered, value) VALUES (\"" + CID + "\", \"" + orderDate
				+ "\", \"" + qtyOrdered + "\", \""+ value+ "\")";

		DatabaseConnection.processUpdate(insert);
	}
	public void read() {
		String select = "SELECT * FROM orders";
		ResultSet results = DatabaseConnection.processQuery(select);

		try {
			while (results.next()) {
				System.out.println("OID: " + results.getInt("OID") + ", " + "CID: " + results.getInt("CID") + ", "
						+ "Order date: " + results.getString("order_date") + ", " + "Quantity ordered: " + results.getInt("qty_ordered") +  ", " + "Value: " + results.getDouble("value"));
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
