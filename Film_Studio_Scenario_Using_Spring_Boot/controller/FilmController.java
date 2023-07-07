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

import com.app.dto.FilmReqDto;
import com.app.dto.FilmUpdationDto;
import com.app.entities.Film;
import com.app.services.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {
	@Autowired
	private FilmService service;
	
	@GetMapping("/details")
	public List<Film> details(){
		return service.getDetails();
	}
	
	@PostMapping("/insert")
	public Film insert(@RequestBody FilmReqDto req) {
		Film insertFilm = service.insertFilm(req);
	return insertFilm;
	}
	
	@PutMapping("/update")
	public Film update(@RequestBody FilmUpdationDto f) {
		return service.updateFilm(f);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return service.deleteFilm(id);
	}
}
