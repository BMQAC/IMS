package com.qa.business;

import com.qa.interoperability.Scan;
import com.qa.persistence.DatabaseConnection;

public class Application {

	public void startApplication() {
		DatabaseConnection.connect();
		Scan scan = new Scan();
		Menu menu = new Menu();
		
		menu.displayMenu();
		
		int option = scan.inputInt();

		while (option != 8) {
			switch (option) {
			case 1:
				menu.enterCustomer();
				break;
			case 2:
				menu.displayCustomers();
				break;
			case 3:
				menu.enterBook();
				break;
			case 4:
				menu.displayBooks();
				break;
			case 5:
				menu.enterOrder();
				break;
			case 6:
				menu.displayOrders();
				break;
//			case 7:
//				cl.calcCost;
//				break;
			default:
				System.out.println("Invalid choice, please choose again:");
				option = scan.inputInt();
				continue;
			}
			
			System.out.println("\nDo you want to continue working (y/n)?");
			String optiontwo = scan.inputString();

			while (true) {
				if (optiontwo.equalsIgnoreCase("y")) {
					menu.displayMenu();
					option = scan.inputInt();
					break;
				} else if (optiontwo.equalsIgnoreCase("n")) {
					option = 8;
					break;
				} else {
					System.out.println("Invalid choice, please choose again:");
					optiontwo = scan.inputString();
				}
			}
		}
		
		DatabaseConnection.disconnect();
		System.out.println("\nGoodbye !!!");
		scan.closeScan();
	}
}
