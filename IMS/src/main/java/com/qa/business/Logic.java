package com.qa.business;

import com.qa.interoperability.Scan;
import com.qa.models.Book;
import com.qa.models.Customer;
import com.qa.models.Order;

public class Logic {

	Scan scan = new Scan();
	Customer customer = new Customer();
	Book book = new Book();
	Order order = new Order();

	public Logic() {

	}
	
	public void calcCost() {
		System.out.println("Select a BID");
		int BID = sc.inputInt();
		double price = book(BID).getPrice();
		
		System.out.println("\nHow many copies do you want");
		int quantity = sc.inputInt();
		
		System.out.println("\nThe value of you're order is:");
		double value = price * quantity;
		System.out.println(value);
		
		System.out.println("Add new value to order(y");
	}
}
