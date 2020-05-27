package com.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.entity.RoleEntity;
import com.core.entity.UserDetailEntity;
import com.core.exception.CommonException;
import com.core.repository.RoleRepo;
import com.core.repository.UserDetailRepo;
import com.core.request.UserRequest;
import com.core.response.UserDetailResponse;
import com.core.response.UserResponse;
import com.core.service.UserService;
import com.core.util.RoleUtil;
import com.core.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailRepo userDetailRepo;

	@Override
	public UserDetailResponse[] getAllUsers() throws CommonException {
		List<UserDetailEntity> userDetailEntityList = userDetailRepo.findAll();
		return UserUtil.buildUserResponse(userDetailEntityList);
	}

	@Override
	public UserDetailResponse getUser(Integer id) throws CommonException {
		Optional<UserDetailEntity> userDetailEntityOpt = userDetailRepo.findById(id);
		if (userDetailEntityOpt.isPresent()) {
			return UserUtil.buildUserResponse(userDetailEntityOpt);
		} else {
			throw new CommonException("User ID " + id + " doesn't exist");
		}
	}

	@Override
	public UserDetailResponse createOrUpdateUser(UserRequest roleRequest) throws CommonException {
		return null;
	}

	@Override
	public boolean deleteUser(Integer id) throws CommonException {
		Optional<UserDetailEntity> userDetailEntityOpt = userDetailRepo.findById(id);

		if (userDetailEntityOpt.isPresent()) {
			UserDetailEntity userDetailEntity = userDetailEntityOpt.get();
			userDetailEntity.setDeleted("True");
			userDetailRepo.save(userDetailEntity);
			return true;
		} else {
			throw new CommonException("UserID " + id + " doesn't exist");
		}
	}

}
