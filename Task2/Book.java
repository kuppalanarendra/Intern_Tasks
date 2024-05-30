package com.mini_library;
//Book Class
public class Book {
	
	//fiels required for book class 
	
	private int bookId; 
	private String title;
	private String author;
	private boolean isIssued;
	
	//Parameterized Constructor
	public Book(int bookId, String title, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		
	}
    //Encapsulation
	//In order to get private data outside of the class we need 
    //to provide getter and setters  are provided
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	

}
