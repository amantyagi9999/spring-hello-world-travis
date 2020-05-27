package com.core.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.manager.UserManager;
import com.core.request.TestRequest;
import com.core.request.UserRequest;
import com.core.response.responsemanager.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserManager userManager;

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> getAllUsers() {

		return userManager.getAllUsers();
	}

	@GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> getUser(@Valid @PathVariable("id") Integer id) {

		return userManager.getUser(id);
	}

	@PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> createOrUpdateUser(@Valid @RequestBody UserRequest userRequest) {
		return userManager.createOrUpdateUser(userRequest);
	}

	@PutMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> createOrUpdateUser(@Valid @PathVariable(value = "id") Integer id,
			@Valid @RequestBody UserRequest userRequest) {
		userRequest.setId(id);
		return userManager.createOrUpdateUser(userRequest);
	}

	@DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> deleteUser(@Valid @PathVariable(value = "id") Integer id) {
		return userManager.deleteUser(id);
	}

}
