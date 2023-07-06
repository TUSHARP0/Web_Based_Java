package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Author;
import com.app.entities.Books;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository repo;
	@Override
	public List<Author> getDetails() {
		
		return repo.findAll();
	}

	@Override
	public Author addAuthor(Author b) {
		// TODO Auto-generated method stub
		return repo.save(b);
	}

	@Override
	public Author updateAuthor(Author b) {
		// TODO Auto-generated method stub
		return repo.save(b);
	}

	@Override
	public String deleteAuthor(Integer id) {
		String msg="Deletion Failed"+id;
		if(repo.existsById(id)) {
			repo.deleteById(id);
			msg="Deleted Succesully"+id;
		}
		return msg;
	}

}
