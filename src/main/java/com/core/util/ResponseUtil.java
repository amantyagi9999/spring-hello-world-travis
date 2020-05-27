package com.core.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;

import com.core.response.responsemanager.ApiError;
import com.core.response.responsemanager.ApiResponse;
import com.core.response.responsemanager.ApiResult;
import com.core.util.constants.CoreConstants;

public class ResponseUtil {

	public static ApiResponse buildSuccessResponse() {
		ApiResponse response = new ApiResponse();
		response.setStatus(true);
		return response;
	}

	public static ApiResponse buildSuccessResponse(ApiResult... results) {
		ApiResponse response = new ApiResponse();
		response.setStatus(true);

		if (results != null) {
			response.setResults(Arrays.asList(results));
		}
		return response;
	}

	public static ApiResponse buildErrorResponse(ApiError... errors) {
		ApiResponse response = new ApiResponse();
		response.setStatus(true);

		if (ArrayUtils.isNotEmpty(errors)) {
			response.setErrors(Arrays.asList(errors));
		}
		return response;
	}
	
	public static ApiResponse buildBadRequestResponse() {
		ApiError badRequestError = new ApiError(HttpStatus.BAD_REQUEST,
				CoreConstants.BAD_REQUEST_ERROR_MESSAGE);

		return buildErrorResponse(badRequestError);
	}
	
	public static <T> ApiResponse buildBadRequestResponse(Set<ConstraintViolation<T>> set) {
		Map<String, String> errorMessages = new HashMap<String, String>();
		for(ConstraintViolation<T> voilation : set) {
			errorMessages.put(voilation.getPropertyPath().toString(), voilation.getMessage());
		}
		ApiError badRequestError = new ApiError(HttpStatus.BAD_REQUEST,
				CoreConstants.BAD_REQUEST_ERROR_MESSAGE);

		return buildErrorResponse(badRequestError);
	}

}
