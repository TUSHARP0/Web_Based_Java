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
import com.app.entities.Author;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService service;
	
	@GetMapping("/details")
	public List<Author> details(){
		return service.getDetails();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Author b) {
		Author addAuthor = service.addAuthor(b);
		return "Book Inserted";
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponce delete(@PathVariable Integer id) {
		return new ApiResponce(service.deleteAuthor(id));
	}
	
	@PutMapping("/update")
	public Author update(@RequestBody Author b) {
		return service.updateAuthor(b);
	}
}	
