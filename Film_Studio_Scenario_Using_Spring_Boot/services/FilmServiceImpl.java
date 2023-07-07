package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.FilmReqDto;
import com.app.dto.FilmUpdationDto;
import com.app.entities.Film;
import com.app.entities.Producer;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.FilmRepository;
import com.app.repository.ProducerRepostiroy;

@Service
@Transactional
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProducerRepostiroy prodRepo; 
	@Override
	public List<Film> getDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Film insertFilm(FilmReqDto req) {
		int id = req.getPid();
		Producer prod=prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Producer"));
		Film newFilm=mapper.map(req, Film.class);
		prod.addFilm(newFilm);
		repo.save(newFilm);
		return newFilm;
	}

	@Override
	public Film updateFilm(FilmUpdationDto f) {
		int filmId=f.getId();
		Film updatedFilm = repo.findById(filmId).orElseThrow(()->new ResourceNotFoundException("Can't update film"));
		updatedFilm.setFilmName(f.getFilmName());
		updatedFilm.setPrice(f.getPrice());
		updatedFilm.setRating(f.getRating());
		updatedFilm.setReleaseDate(f.getReleaseDate());
		Film update = repo.save(updatedFilm);
		return update;
	}

	@Override
	public String deleteFilm(Integer id) {
		String msg="Can't Delete";
		if(repo.existsById(id)) {
			repo.deleteById(id);
			msg="Deleted Succesfully";
		}
		return msg;
	}
	
	

}
