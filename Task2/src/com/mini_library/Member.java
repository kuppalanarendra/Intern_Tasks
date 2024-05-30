package com.mini_library;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Member {
	//fields required for member class
    private int memberID;
    private String name;
    private int maxBooksIssued;
    private List<Book> currentIssuedBooks;
    
    
  //Parameterized constructor
    public Member(int memberID, String name, int maxBooksIssued) {
        this.memberID = memberID;
        this.name = name;
        this.maxBooksIssued = maxBooksIssued;
        this.currentIssuedBooks = new ArrayList<>(); // Initialize the list
    }

    // Getters and Setters
    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooksIssued() {
        return maxBooksIssued;
    }

    public List<Book> getCurrentIssuedBooks() {
        return currentIssuedBooks;
    }

    public void issueBook(Book book) {
        if (currentIssuedBooks.size() < maxBooksIssued) {
            currentIssuedBooks.add(book);
           
            book.setIssued(true);
        }
    }

    public void returnBook(Book book) {
        if (currentIssuedBooks.remove(book)) {
            book.setIssued(false);
        }
    }
}

