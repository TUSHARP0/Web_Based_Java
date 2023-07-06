package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApiResponce {
	private String message;
	private LocalDateTime timestamp;
	
	public ApiResponce(String message) {
		this.message=message;
		timestamp=LocalDateTime.now();
	}
}
