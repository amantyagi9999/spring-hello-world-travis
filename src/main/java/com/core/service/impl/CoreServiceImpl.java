package com.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.core.exception.CommonException;
import com.core.response.UserDetailResponse;
import com.core.service.CoreService;
import com.core.util.constants.CoreConstants;

@Service
public class CoreServiceImpl implements CoreService {

	private static Logger logger = LogManager.getLogger(CoreServiceImpl.class);

	public UserDetailResponse[] getUser(Integer id) throws CommonException {

		if (id == 1) {
			List<UserDetailResponse> userDetailResponseList = new ArrayList<UserDetailResponse>();
			UserDetailResponse userDetailResponse = new UserDetailResponse();
			userDetailResponse.setEmailId("amant@netapp.com");
			userDetailResponse.setFirstName("Aman");
			userDetailResponse.setLastName("Tyagi");
			userDetailResponseList.add(userDetailResponse);
			logger.debug("This method is to get particular user");
			return userDetailResponseList.toArray(new UserDetailResponse[userDetailResponseList.size()]);

		} else {
			throw new CommonException(CoreConstants.RESOURCE_NOT_FOUND_ERROR_MESSAGE);

		}

	}

}
