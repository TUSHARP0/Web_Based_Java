package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Books;
import com.app.repository.BookRepository;
@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repo;
	@Override
	public List<Books> getDetails() {
		
		return repo.findAll();
	}
	@Override
	public Books addBook(Books b) {
		
		return repo.save(b);
	}
	@Override
	public String deleteBook(Integer id) {
		String msg="Deletion Failed"+id;
		if(repo.existsById(id)) {
			Books b=new Books();
			repo.deleteById(id);
			msg="Deleted Succesully"+id+" "+b.getName();
		}
		return msg;
	}
	@Override
	public Books updateBook(Books b) {
		
		return repo.save(b);
	}

}
