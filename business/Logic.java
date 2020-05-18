package com.qa.business;

import com.qa.interoperability.Scan;
import com.qa.models.Book;
import com.qa.models.Order;

public class Logic {

	private Scan scan = new Scan();
	private Book book = new Book();
	private Order order = new Order();

	public Logic() {

	}

	public void calcCost() {
		String input;
		do {
			System.out.println("Which book would you like to calculate a cost for, please select a BID:");
			int BID = scan.inputInt();
			double price = book.returnPrice(BID);

			System.out.println("How many copies would you like ?");
			int quantity = scan.inputInt();

			System.out.println("The value of you're order is: ");
			double value = price * quantity;
			System.out.println(value);

			System.out.println("Would you like to save this order(y/n) ?\n");
			input = scan.inputString();

			while (true) {
				if (input.equalsIgnoreCase("y")) {
					System.out.println("Please enter the CID of the customer you would like to assign this order:");
					int CID = scan.inputInt();
					
					System.out.println("Please enter the date this order was made (YYYY-MM-DD):");
					String orderDate = scan.inputString();
					
					order.addOrder(CID, orderDate, quantity ,value);
					System.out.println("Below is the order table showing your newly inserted order\n");
					order.read();
					break;
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("Please recalculate your order:\n");
					break;
				} else {
					System.out.println("Invalid choice, please choose again:");
					input = scan.inputString();
				}
			}

		} while (input.equalsIgnoreCase("n"));
	}
}
