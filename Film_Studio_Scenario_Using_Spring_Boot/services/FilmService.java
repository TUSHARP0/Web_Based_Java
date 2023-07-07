package com.app.services;

import java.util.List;

import com.app.dto.FilmReqDto;
import com.app.dto.FilmUpdationDto;
import com.app.entities.Film;

public interface FilmService {

	List<Film> getDetails();
	
	Film insertFilm(FilmReqDto req);
	
	Film updateFilm(FilmUpdationDto f);
	
	String deleteFilm(Integer id);
}
