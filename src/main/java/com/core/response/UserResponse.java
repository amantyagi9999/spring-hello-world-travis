package com.core.response;

import com.core.response.responsemanager.ApiResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserResponse extends ApiResult {

	String firstName;
	String lastName;
	String emailId;
	String roleId;
	String userId;
	String password;
	String phone;
	String createdBy;
	String updatedBy;

}
