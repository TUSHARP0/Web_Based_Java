package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude="password")
@JsonIgnoreType
public class Producer extends BaseEntity {
	@Column(unique=true)
	private String producerName;
	@Min(20)
	private int age;
	@Email
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%&])[a-zA-Z0-9!@#$%&]{6,12}$")
	private String password;
	@Past
	private LocalDate dob;
	
	@OneToMany(mappedBy="producerId",fetch = FetchType.EAGER)
	List<Film> filmList=new ArrayList<>();

	public Producer(String producerName, @Min(20) int age, @Email String email,
			@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%&])[a-zA-Z0-9!@#$%&]{6,12}$") String password,
			@Past LocalDate dob) {
		super();
		this.producerName = producerName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	
	public void addFilm(Film f) {
		filmList.add(f);
		f.setProducerId(this);
	}
}
