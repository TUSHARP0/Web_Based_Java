package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponce;
import com.app.entities.Books;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/details")
	public List<Books> details(){
		return service.getDetails();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Books b) {
		Books addBook = service.addBook(b);
		return "Book Inserted";
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponce delete(@PathVariable Integer id) {
		return new ApiResponce(service.deleteBook(id));
	}
	
	@PutMapping("/update")
	public Books update(@RequestBody Books b) {
		return service.updateBook(b);
	}
}
