package com.core.service;

import com.core.exception.CommonException;
import com.core.response.UserDetailResponse;

public interface CoreService {

	public UserDetailResponse[] getUser(Integer id) throws CommonException;
}
