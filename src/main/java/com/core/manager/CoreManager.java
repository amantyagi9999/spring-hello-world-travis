package com.core.manager;

import org.apache.logging.log4j.LogManager;

import com.core.exception.CommonException;
import com.core.request.TestRequest;
import com.core.response.UserDetailResponse;
import com.core.response.responsemanager.AbstractResponseManager;
import com.core.response.responsemanager.ApiResponse;
import com.core.service.CoreService;
import com.core.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

@Service
public class CoreManager extends AbstractResponseManager {

	private static Logger logger = LogManager.getLogger(CoreManager.class);

	@Autowired
	CoreService coreService;

	public ResponseEntity<ApiResponse> getUser(Integer userId) {
		logger.info("Get User based on userId");
		try {
			ApiResponse apiResponse = new ApiResponse();
			UserDetailResponse[] userDetailResponse;
			userDetailResponse = coreService.getUser(userId);
			if (userDetailResponse.length != 0) {
				apiResponse = ResponseUtil.buildSuccessResponse(userDetailResponse);
				return buildEntityResponse(HttpStatus.OK, apiResponse);
			}

		} catch (CommonException e) {
			ApiResponse apiErrorResponse = new ApiResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiErrorResponse);
		}
		return null;

	}
	
	public ResponseEntity<ApiResponse> create(TestRequest testRequest) {
		logger.info("Get User based on userId");
		try {
			ApiResponse apiResponse = new ApiResponse();
			UserDetailResponse[] userDetailResponse;
			//userDetailResponse = coreService.getUser(userId);
			if (testRequest != null) {
				apiResponse = ResponseUtil.buildSuccessResponse();
				return buildEntityResponse(HttpStatus.OK, apiResponse);
			}

		} catch (Exception e) {
			ApiResponse apiErrorResponse = new ApiResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiErrorResponse);
		}
		return null;

	}
}
