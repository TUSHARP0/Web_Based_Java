package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Film extends BaseEntity {
	@Column(unique=true)
	private String filmName;
	private double price;
	@Past
	private LocalDate releaseDate;
	@Enumerated(EnumType.STRING)
	private Rating rating;
	@ManyToOne
	private Producer producerId;
	public Film(String filmName, double price, @Past LocalDate releaseDate, Rating rating) {
		super();
		this.filmName = filmName;
		this.price = price;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}
	
	
}
