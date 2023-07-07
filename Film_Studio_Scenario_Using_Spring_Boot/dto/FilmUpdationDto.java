package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Rating;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FilmUpdationDto {
	private Integer id;
	private String filmName;
	private double price;
	private LocalDate releaseDate;
	private Rating rating;
	private Integer pid;
}
