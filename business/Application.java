package com.qa.business;

import com.qa.interoperability.Scan;
import com.qa.persistence.DatabaseConnection;

public class Application {
	Scan scan = new Scan();
	Menu menu = new Menu();
	Logic logic = new Logic();
	
	public Application() {
		
	}

	public void startApplication() {
		DatabaseConnection.connect();
		menu.displayMenu();
		int option = scan.inputInt();

		while (option != 7) {
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
				logic.calcCost();
				break;
			case 6:
				menu.displayOrders();
				break;
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
					option = 7;
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
