package com.app.service;

import java.util.List;

import com.app.entities.Author;
import com.app.entities.Books;

public interface AuthorService {
	List<Author> getDetails();
	
	Author addAuthor(Author b);
	
	Author updateAuthor(Author b);
	
	String deleteAuthor(Integer id);
}
