package com.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

import com.core.response.responsemanager.ApiResult;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserDetailResponse extends ApiResult {

	private String userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String phone;
	private List<String> roles;
	private String createdBy;
	private String updatedBy;

}