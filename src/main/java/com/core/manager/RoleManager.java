package com.core.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.core.exception.CommonException;
import com.core.request.RoleRequest;
import com.core.request.TestRequest;
import com.core.response.RoleResponse;
import com.core.response.UserDetailResponse;
import com.core.response.responsemanager.AbstractResponseManager;
import com.core.response.responsemanager.ApiResponse;
import com.core.service.RoleService;
import com.core.util.ResponseUtil;

@Service
public class RoleManager extends AbstractResponseManager {

	private static Logger logger = LogManager.getLogger(RoleManager.class);

	@Autowired
	RoleService roleService;

	public ResponseEntity<ApiResponse> getAllRoles() {
		logger.info("Get Role based on roleId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			RoleResponse[] RoleResponse;
			RoleResponse = roleService.getAllRoles();
			apiResponse = ResponseUtil.buildSuccessResponse(RoleResponse);
			apiResponse.setMessage("Successfull");
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		} catch (CommonException e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			apiResponse.setMessage("Failed");
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}

	public ResponseEntity<ApiResponse> getRoles(Integer id) {
		logger.info("Get Role based on roleId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			RoleResponse roleResponse;
			roleResponse = roleService.getRoles(id);
			apiResponse = ResponseUtil.buildSuccessResponse(roleResponse);
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (CommonException e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}

	}

	public ResponseEntity<ApiResponse> createRole(RoleRequest roleRequest) {
		logger.info("Get Role based on RoleId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			RoleResponse roleResponse;
			roleResponse = roleService.createOrUpdateRole(roleRequest);
			if (roleResponse != null) {
				apiResponse.setMessage("Role Created Successfully");
				apiResponse = ResponseUtil.buildSuccessResponse(roleResponse);
			}
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (Exception e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}
	}

	public ResponseEntity<ApiResponse> updateRole(RoleRequest roleRequest) {
		logger.info("Get Role based on RoleId");
		ApiResponse apiResponse = new ApiResponse();
		try {
			RoleResponse roleResponse;
			roleResponse = roleService.createOrUpdateRole(roleRequest);
			if (roleResponse != null) {
				apiResponse.setMessage("Role Updated Successfully");
				apiResponse = ResponseUtil.buildSuccessResponse(roleResponse);
			}
			return buildEntityResponse(HttpStatus.OK, apiResponse);

		} catch (Exception e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}
	}

	public ResponseEntity<ApiResponse> deleteRole(Integer id) {
		logger.info("Get Role based on roleId");
		boolean success = false;
		ApiResponse apiResponse = new ApiResponse();
		try {
			if (success) {
				success = roleService.deleteRole(id);
				apiResponse.setMessage("Successfull");
				apiResponse = ResponseUtil.buildSuccessResponse();

			} else {
				apiResponse.setMessage("Failed");
				apiResponse = ResponseUtil.buildSuccessResponse();
			}
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		} catch (CommonException e) {
			apiResponse.setMessage(e.getMessage());
			apiResponse.setDescription(e.getLocalizedMessage());
			apiResponse.setMessage("Failed");
			return buildEntityResponse(HttpStatus.OK, apiResponse);
		}
	}
}
