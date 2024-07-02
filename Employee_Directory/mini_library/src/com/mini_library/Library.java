package com.mini_library;

import java.util.ArrayList;
import java.util.List;

//Library class implements the LibraryOperations interface to 
//provide implementation for interface methods
public class Library implements LibraryOperations {
	
	//fields for library class
	private List<Book> books; // List of books because library contains so many books
	private List<Member> members; //list of members who are bring library books
	
	public Library() {
		books = new ArrayList<>(); //Arraylist implematation class for list
		members = new ArrayList<>();
		
	}
	
	//Getter and Setters
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
	//Book isssue method based on the condition of checking maxBooksIssued
	@Override
	public boolean issueBook(Book book, Member member) {
		if(!book.isIssued()&& member.getCurrentIssuedBooks().size()<member.getMaxBooksIssued()) {
			member.issueBook(book);
			
			return true;
		}
		return false;
	
	}

	//Book return method if book  present is already issued 
	@Override
	public boolean returnBook(Book book, Member member) {
		if(book.isIssued()&&member.getCurrentIssuedBooks().contains(book)) {
			member.returnBook(book);
			return true;
		}
		return false;
	}
	
}
