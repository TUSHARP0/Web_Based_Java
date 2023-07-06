package com.app.service;

import java.util.List;

import com.app.entities.Books;

public interface BookService {
	List<Books> getDetails();
	
	Books addBook(Books b);
	
	Books updateBook(Books b);
	
	String deleteBook(Integer id);
}
