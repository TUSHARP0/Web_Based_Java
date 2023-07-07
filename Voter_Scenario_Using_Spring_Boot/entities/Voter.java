package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="password")
public class Voter extends BaseEntity{
	private String voterName;
	private String city;
	@Column(unique=true)
	@Email
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%&])[a-zA-Z0-9!@#$%&]{6,12}$")
	private String password;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Past
	private LocalDate dob;
	@Min(18)
	private int age;
	
	private boolean status;
	
}
