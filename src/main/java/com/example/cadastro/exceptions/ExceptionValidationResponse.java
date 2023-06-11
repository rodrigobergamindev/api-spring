package com.example.cadastro.exceptions;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionValidationResponse {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private List<String> messages;
	private String details;
	
}
