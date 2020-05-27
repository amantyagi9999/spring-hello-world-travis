package com.core.response.responsemanager;

import java.util.Collection;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
public @Data class ApiResponse {

	public ApiResponse() {
		this.requestId = UUID.randomUUID().toString();
	}
	
	private String requestId;
	private boolean status;
	private String message;
	private String description;

	private Collection<ApiResult> results = null;
	private Collection<ApiError> errors = null;

}
