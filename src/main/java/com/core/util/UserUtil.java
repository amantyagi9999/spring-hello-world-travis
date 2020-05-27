package com.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.core.entity.RoleEntity;
import com.core.entity.UserDetailEntity;
import com.core.response.RoleResponse;
import com.core.response.UserDetailResponse;

public class UserUtil {
	
	public static UserDetailResponse buildCreateResponse(UserDetailEntity userDetailEntity) {
		UserDetailResponse userDetailResponse = new UserDetailResponse();
		userDetailResponse.setFirstName(userDetailEntity.getFirstName());
		userDetailResponse.setLastName(userDetailEntity.getLastName());
		userDetailResponse.setEmailId(userDetailEntity.getEmailId());
		userDetailResponse.setUserId(userDetailEntity.getUserId());
		userDetailResponse.setPassword(userDetailEntity.getPassword());
		userDetailResponse.setPhone(userDetailEntity.getPhone());
		return userDetailResponse;
	}

	public static UserDetailResponse[] buildUserResponse(List<UserDetailEntity> userDetailEntitylist) {
		List<UserDetailResponse> userDetailResponseList = new ArrayList<UserDetailResponse>();
		for (int i = 0; i < userDetailEntitylist.size(); i++) {
			UserDetailResponse userDetailResponse = new UserDetailResponse();
			userDetailResponse.setFirstName(userDetailEntitylist.get(i).getFirstName());
			userDetailResponse.setLastName(userDetailEntitylist.get(i).getLastName());
			userDetailResponse.setEmailId(userDetailEntitylist.get(i).getEmailId());
			userDetailResponse.setUserId(userDetailEntitylist.get(i).getUserId());
			userDetailResponse.setPassword(userDetailEntitylist.get(i).getPassword());
			userDetailResponse.setPhone(userDetailEntitylist.get(i).getPhone());
			userDetailResponseList.add(userDetailResponse);
		}
		return userDetailResponseList.toArray(new UserDetailResponse[userDetailResponseList.size()]);

	}

	public static UserDetailResponse buildUserResponse(Optional<UserDetailEntity> userDetailEntityOpt) {
		UserDetailResponse userDetailResponse = new UserDetailResponse();
		userDetailResponse.setFirstName(userDetailEntityOpt.get().getFirstName());
		userDetailResponse.setLastName(userDetailEntityOpt.get().getLastName());
		userDetailResponse.setEmailId(userDetailEntityOpt.get().getEmailId());
		userDetailResponse.setUserId(userDetailEntityOpt.get().getUserId());
		userDetailResponse.setPassword(userDetailEntityOpt.get().getPassword());
		userDetailResponse.setPhone(userDetailEntityOpt.get().getPhone());
		return userDetailResponse;

	}

}
