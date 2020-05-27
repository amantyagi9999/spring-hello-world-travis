package com.core.response.responsemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.core.response.responsemanager.ApiResponse;

public class AbstractResponseManager {

	protected ResponseEntity<ApiResponse> buildEntityResponse(HttpStatus responseStatus, ApiResponse apiResponse) {
		ResponseEntity<ApiResponse> responseEntity = null;
		if (apiResponse == null) {
			responseEntity = ResponseEntity.status(responseStatus).build();
		} else {
			responseEntity = new ResponseEntity<ApiResponse>(apiResponse, responseStatus);
		}
		return responseEntity;

	}

}
