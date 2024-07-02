package com.mini_library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	//Creation of Object for Library class
        Library library = new Library();
        
        //Cretion object for Librarion class and passing parameter to constructor
        Librarian librarian = new Librarian(1, "Rajesh", 10);

        
        //creation of object for Book class and passing parametrs to constructors 
        //the parameters are bookId,title and author
        System.out.println("Enter the Book1 details");
        int bookId=sc.nextInt();
        String title=sc.next();
        String author=sc.next();
        
        Book book1 = new Book(bookId, title, author);
        System.out.println("Enter the Book2 details");
        int bookId1=sc.nextInt();
        String title1=sc.next();
        String author1=sc.next();
        Book book2 = new Book(bookId1, title1, author1);
        
      //First I need to add the books to library 
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
       System.err.println("All Books added to library");
       System.out.println("Details of the Books in the Library");
       for(Book book:library.getBooks()) {
    	   System.out.println(book.getBookId()+" "+book.getTitle()+" "+book.getAuthor());
       }
        
        //Creation of object to StudentMeber and TeacherMember class
        StudentMember student = new StudentMember(2, "Student Durga",3);//3 is the max books issued
        TeacherMember teacher = new TeacherMember(3, "Teacher Bhavani",5);// 5 is the max books issued
        System.out.println();
        
             
        
     //From library I need to issue the book1 to the student or teacher 
     //to check the issue and return the books based on the maximun books issued
        
       // from below I want  to give book1 to both student and teacher
       //to check the issue method behaviour
        
        System.err.println("Issuing of Books");
        
        if(library.issueBook(book1, student)) { 
        	System.out.println(book1.getTitle()+ " Book is  issued to "+student.getName());
        }else {
        	System.out.println("Failed to issue book"+book1.getTitle());
        }
        
        if(library.issueBook(book2, teacher)) {
        	System.out.println(book2.getTitle()+" Book is  issued to "+teacher.getName());
        }else {
        	System.out.println("Failed to issue book "+book1.getTitle());
        	
        }
        System.out.println();
     System.err.println("Returning of books");
     //return the book to the library   
        if(library.returnBook(book1, student)) {
        	System.out.println(book1.getTitle()+" is returned successfully from "+student.getName());
        }
        
        if(library.returnBook(book2, teacher)) {
        	System.out.println(book2.getTitle()+" is returned successfully from "+teacher.getName());
        }
        
        
     //from library i want to remove the book which I was issued
        
//        librarian.removeBook(library, book1);
//        librarian.removeBook(library, book2);

        // Final output demonstration
        System.err.println("Library books after operations:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle());
        }
    }
}

