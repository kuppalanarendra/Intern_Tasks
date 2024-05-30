package com.mini_library;
//Librarian Class

public class Librarian extends Member { //extends keyword Inheritence
	
	//we need to provide parameterized constructor  because whhic extends member class
	public Librarian(int memberID, String name, int maxBooksIssued) {
        super(memberID, name, maxBooksIssued);
    }
    
	//Librarian need to add the book to the library
	// for that add method is created in Librarian Class
    public void addBook(Library library, Book book) {
        library.getBooks().add(book);
        
       
    }
  //Librarian need to remove the book from library after issuing
  	// for that remove  method is created in Librarian Class
    public void removeBook(Library library, Book book) {
        library.getBooks().remove(book);
    }

}
