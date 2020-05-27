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

import com.core.manager.RoleManager;
import com.core.manager.UserManager;
import com.core.request.RoleRequest;
import com.core.request.TestRequest;
import com.core.response.responsemanager.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RoleController {

	private static Logger logger = LogManager.getLogger(RoleController.class);

	@Autowired
	RoleManager roleManager;

	@GetMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> getAllRoles() {

		return roleManager.getAllRoles();
	}

	@GetMapping(path = "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> getRoles(@Valid @PathVariable("id") Integer id) {
		return roleManager.getRoles(id);
	}

	@PostMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> createRole(@Valid @RequestBody RoleRequest roleRequest) {
		return roleManager.createRole(roleRequest);
	}

	@PutMapping(path = "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> updateRole(@Valid @PathVariable(value = "id") Integer id,
			@Valid @RequestBody RoleRequest roleRequest) {
		roleRequest.setId(id);
		return roleManager.updateRole(roleRequest);
	}

	@DeleteMapping(path = "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> deleteRole(@Valid @PathVariable(value = "id") Integer id) {
		return roleManager.deleteRole(id);
	}

}
