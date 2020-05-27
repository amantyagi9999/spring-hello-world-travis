package com.core.service;

import com.core.exception.CommonException;
import com.core.request.UserRequest;
import com.core.response.UserDetailResponse;
import com.core.response.UserResponse;

public interface UserService {


	public UserDetailResponse[] getAllUsers() throws CommonException;

	public UserDetailResponse getUser(Integer id) throws CommonException;

	public UserDetailResponse createOrUpdateUser(UserRequest userRequest) throws CommonException;

	public boolean deleteUser(Integer id) throws CommonException;

}