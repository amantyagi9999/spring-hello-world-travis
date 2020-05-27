package com.core.response.responsemanager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public @Data class ApiError {

	private HttpStatus status;
	private String message;
	private String description;
	private List<String> errors;
	
	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ApiError(HttpStatus status, String message, String description, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.description = description;
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String description, String error) {
		super();
		this.status = status;
		this.message = message;
		this.description = description;
		errors = Arrays.asList(error);
	}

}
