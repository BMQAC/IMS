package com.qa.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.persistence.DatabaseConnection;

public class Book {
	
	private int BID = 0;
	private String title = null;
	private String genre = null;
	private String authorName = null;
	private String publisher = null;
	private String publishDate = null;
	private double price = 0.0;
	private String ISBN = null;
	
	public Book() {
		
	}
	
	public Book(String title, String genre, String authorName, String publisher, String publishDate, double price, String ISBN) {
		super();
		this.title = title;
		this.genre = genre;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
		this.ISBN = ISBN;
	}

//  This readBook() is explicitly used for testing the SELECT functionality of MySQL in java 
	public Book readBook(String title) {
		String select = "SELECT * FROM books WHERE title =\"" + title + "\"";
		ResultSet results = DatabaseConnection.processQuery(select);
		
		String titleTemp = null;
		String genreTemp = null;
		String authorNameTemp = null;
		String publisherTemp = null;
		String publishDateTemp = null;
		Double priceTemp = null;
		String ISBNTemp = null;
		
		try {
			while (results.next()) {
				titleTemp = results.getString("title");
				genreTemp = results.getString("genre");
				authorNameTemp = results.getString("author_name");
				publisherTemp = results.getString("publisher");
				publishDateTemp  = results.getString("publish_date");
				priceTemp = results.getDouble("price");
				ISBNTemp = results.getString("ISBN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Book(titleTemp, genreTemp, authorNameTemp, publisherTemp , publishDateTemp , priceTemp, ISBNTemp);
	}
	
//  This read() Method is explicitly used in my application 	
	public void read() {
		String select = "SELECT * FROM books";
		ResultSet results = DatabaseConnection.processQuery(select);

		try {
			while (results.next()) {
				System.out.println("BID: " + results.getInt("BID") + ", " + "title: " + results.getString("title") + ", "
						+ "genre: " + results.getString("genre") + ", " + "author name: " + results.getString("author_name") + ", "
						+ "publisher: "+ results.getString("publisher") + ", " + "publish date: " + results.getString("publish_date") + ", "
						+ "price: " + results.getDouble("price") + ", " + "ISBN: " + results.getString("ISBN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createBook(Book b) {
		String insert = "INSERT INTO books (title, genre, author_name, publisher, publish_date, price, ISBN) VALUES (\""
				+ b.getTitle() + "\", \"" + b.getGenre() + "\", \"" + b.getAuthorName() + "\", \"" + b.getPublisher() + "\", \"" + b.getPublishDate()
				+ "\", \"" + b.getPrice() + "\", \"" + b.getISBN() + "\")";

		DatabaseConnection.processUpdate(insert);
	}
//  The returnPrice() method is used for calculating the order cost in the Logic class 
	public double returnPrice(int BID) {
		String select = "SELECT price FROM books WHERE BID = " + BID;
		ResultSet results = DatabaseConnection.processQuery(select);
		double price = 0.0;
		
		try {
			while (results.next()) {
				price = results.getDouble("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	public void delete(int BID){
		String delete = "DELETE FROM books WHERE BID = " + BID;
		DatabaseConnection.processUpdate(delete);
	}

//  toString() method is used for testing
	@Override
	public String toString() {
		return BID + ", " + title + ", " + genre + ", " + authorName + ", " + publisher + ", " + publishDate + ", " + price + ", " + ISBN;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}
}