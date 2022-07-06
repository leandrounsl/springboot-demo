package com.ap.springboot.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MESSAGE = "No employee with id %s found";

	public EmployeeNotFoundException(UUID employeeId) {
		super(String.format(ERROR_MESSAGE, employeeId.toString()));
	}	
}
