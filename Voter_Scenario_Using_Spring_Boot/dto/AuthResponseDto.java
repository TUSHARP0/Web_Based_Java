package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Gender;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class AuthResponseDto {
	private String voterName;
	private String city;
	private Gender gender;
	private LocalDate dob;
	private int age;
	private boolean status;
	private String msg;
}
