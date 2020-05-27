package com.core.manager;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.core.exception.CommonException;
import com.core.request.UserRequest;
import com.core.response.UserDetailResponse;
import com.core.response.UserResponse;
import com.core.response.responsemanager.AbstractResponseManager;
import com.core.response.responsemanager.ApiResponse;
import com.core.service.UserService;
import com.core.util.ResponseUtil;

@Service
public class UserManager extends AbstractResponseManager {

	private static Logger logger = LogManager.getLogger(UserManager.class);

	@Autowired
	UserService userService;

	public ResponseEntity<ApiResponse> getAllUsers() {
		logger.info("Get user based on userId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			UserDetailResponse[] userDetailResponse;
			userDetailResponse = userService.getAllUsers();
			apiResponse = ResponseUtil.buildSuccessResponse(userDetailResponse);
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		} catch (CommonException e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}

	public ResponseEntity<ApiResponse> getUser(Integer id) {
		logger.info("Get user based on userId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			UserDetailResponse userDetailResponse;
			userDetailResponse = userService.getUser(id);
			apiResponse = ResponseUtil.buildSuccessResponse(userDetailResponse);
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (CommonException e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}

	public ResponseEntity<ApiResponse> createOrUpdateUser(UserRequest userRequest) {
		logger.info("Get user based on userId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			UserDetailResponse userDetailResponse;
			userDetailResponse = userService.createOrUpdateUser(userRequest);
			apiResponse = ResponseUtil.buildSuccessResponse(userDetailResponse);
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (Exception e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}

	public ResponseEntity<ApiResponse> deleteUser(Integer id) {
		logger.info("Get user based on userId");
		boolean success = false;
		ApiResponse apiResponse = new ApiResponse();
		try {
			success = userService.deleteUser(id);
			apiResponse = ResponseUtil.buildSuccessResponse();
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (Exception e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}
}
