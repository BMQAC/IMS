package com.qa.models.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.models.Book;
import com.qa.persistence.DatabaseConnection;

public class BookTest {
	
	@Before
	public void setUpBeforeClass() throws Exception {
		System.out.println("Connecting to the database...");
		DatabaseConnection.connect();	
	}
	
	@Test
	public void testReadCustomer() {		
		Book book = new Book();
		Book book1 = new Book("The Personal MBA", "self-help", "Josh Kaufman", "Penguin", "2012-09-06", 12.99, "978-0-670-91953-6");
		
		String MBA = "The Personal MBA";
		String bookExpected = book1.toString();
		String bookActual = book.readBook(MBA).toString();
		assertEquals("Incorrect reading of books table", bookExpected, bookActual);

	}
	
	@Test
	public void testCreateBook() {
		Book book = new Book();
		Book book1 = new Book("Michael Jordan: The Life", "Autobiography", "Roland Lazenby", "Back Bay", "2015-05-28", 12.99, "978-0-316-19476-1");
		
		book.createBook(book1);
		String MichaelJordan = "Michael Jordan: The Life";
		String bookExpected = book1.toString();
		String bookActual = book.readBook(MichaelJordan).toString();
		assertEquals("No book was added to the books table", bookExpected, bookActual);
	}
	
	@Test
	public void testReturnPrice() {
		Book book = new Book();
		Book book1 = new Book("The Personal MBA", "self-help", "Josh Kaufman", "Penguin", "2012-09-06", 12.99, "978-0-670-91953-6");
		
		double priceExpected = book1.getPrice();
		double priceActual = book.returnPrice(1);		
		
		assertEquals("The book prices don't match",priceExpected , priceActual ,0);
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		System.out.println("Disconnected from the database");
		DatabaseConnection.disconnect();
	}
}

