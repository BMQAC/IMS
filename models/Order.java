package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Order {
	
	private int OID = 0;
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
//  addOrder() is used in the Logic class for calculating the cost of an order	
	public void addOrder(int CID, String orderDate, int qtyOrdered, double value) {
		String insert = "INSERT INTO orders (CID, order_date, qty_ordered, value) VALUES (\"" + CID + "\", \"" + orderDate
				+ "\", \"" + qtyOrdered + "\", \""+ value+ "\")";

		DatabaseConnection.processUpdate(insert);
	}
	
	public void createOrder(Order o) {
		String insert = "INSERT INTO orders (CID, order_date, qty_ordered, value) VALUES (\"" + o.getCID() + "\", \"" + o.getOrderDate()
				+ "\", \"" + o.getQtyOrdered() + "\", \""+ o.getValue()+ "\")";

		DatabaseConnection.processUpdate(insert);
	}
//  readOrder() is explicitly used for testing the SELECT functionality of MySQL in Java 	
	public Order readOrder(int CID) {
		String select = "SELECT * FROM orders WHERE CID =\"" + CID + "\"";
		ResultSet results = DatabaseConnection.processQuery(select);
		
		int CIDTemp = 0;
		String orderDateTemp = null;
		int qtyOrderedTemp = 0;
		double valueTemp = 0.0;
		
		try {
			while (results.next()) {
				CIDTemp = results.getInt("CID");
				orderDateTemp = results.getString("orderDate");
				qtyOrderedTemp = results.getInt("qty_ordered");
				valueTemp = results.getDouble("value");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Order(CIDTemp, orderDateTemp, qtyOrderedTemp, valueTemp);
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
	
	public void delete(int OID){
		String delete = "DELETE FROM orders WHERE OID = " + OID;
		DatabaseConnection.processUpdate(delete);
	}
	
//  toString() method is used for testing
	@Override
	public String toString() {
		return OID + ", " + CID + ", " + orderDate + ", " + qtyOrdered + ", " + value;
	}
	
	public int getOID() {
		return OID;
	}

	public void setOID(int oID) {
		OID = oID;
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
