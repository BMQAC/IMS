package com.qa.business;

import com.qa.interoperability.Scan;
import com.qa.models.Book;
import com.qa.models.Customer;
import com.qa.models.Order;

public class Menu {
	
	Scan scan = new Scan();
	Customer customer = new Customer();
	Book book = new Book();
	Order order = new Order();
	
	public Menu() {
		
	}
	
	public void displayMenu() {
		System.out.println("\n===========================\n"
							+"       Database Menu\n"
							+"===========================\n"
							+"1. Create new customer\n"
							+"2. View all customers\n"
							+"3. Create new book\n"
							+"4. View all books\n"
							+"5. Calculate order cost\n"
							+"6. View all orders\n"
							+"7. Finish\n"
							+"===========================\n"
							+"Please select an option:");
	}

	public void enterCustomer() {
		String input;
		do {
			System.out.println("Please enter first name:");
			customer.setFname(scan.inputString());

			System.out.println("Please enter last name:");
			customer.setLname(scan.inputString());

			System.out.println("Please enteraddress:");
			customer.setAddress(scan.inputString());

			System.out.println("Please enter postcode:");
			customer.setPostcode(scan.inputString());

			System.out.println("Please enter email:");
			customer.setEmail(scan.inputString());

			System.out.println("Please enter age:");
			customer.setAge(scan.inputInt());

			System.out.println("Is this information correct(y/n) ?");
			input = scan.inputString();

			while (true) {
				if (input.equalsIgnoreCase("y")) {
					System.out.println("\nA new customer was added, see below:\n");
					customer.createCustomer(customer);
					customer.read();
					break;
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("Please re-insert values\n");
					break;
				} else {
					System.out.println("Invalid choice, please choose again:");
					input = scan.inputString();
				}
			}
		} while (input.equalsIgnoreCase("n"));
	}

	public void displayCustomers() {
		customer.read();
	}

	public void enterBook() {
		String input;
		do {
			System.out.println("Please enter title:");
			book.setTitle(scan.inputString());

			System.out.println("Please enter genre:");
			book.setGenre(scan.inputString());

			System.out.println("Please enter author name:");
			book.setAuthorName(scan.inputString());

			System.out.println("Please enter publisher:");
			book.setPublisher(scan.inputString());

			System.out.println("Please enter publish date (YYYY-MM-DD):");
			book.setPublishDate(scan.inputString());

			System.out.println("Please enter price (e.g 21.0):");
			book.setPrice(scan.inputDouble());

			System.out.println("Please enter ISBN (xxx-x-xx-xxxxxx-x, x is a number):");
			book.setISBN(scan.inputString());

			System.out.println("Is this information correct(y/n) ?");
			input = scan.inputString();

			while (true) {
				if (input.equalsIgnoreCase("y")) {
					System.out.println("\nA new book was added, see below:\n");
					book.createBook(book);
					book.read();
					break;
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("Please re-insert values\n");
					break;
				} else {
					System.out.println("Invalid choice, please choose again:");
					input = scan.inputString();
				}

			}

		} while (input.equalsIgnoreCase("n"));
	}

	public void displayBooks() {
		book.read();
	}

	public void displayOrders() {
		order.read();
	}
}


