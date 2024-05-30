package com.mini_library;


//Interface for libraryoperations
public interface LibraryOperations {
	
	//An interface contatins only Abstract methods nothing but unimplemented
	
	//Abstract methods
	//issue method which is umimplemnted method

	boolean issueBook(Book book,Member member);
	//return method which also unimplemented method
	boolean returnBook(Book book,Member member);

}
