package com.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.core.entity.RoleEntity;
import com.core.response.RoleResponse;

public class RoleUtil {

	public static RoleResponse buildCreateResponse(RoleEntity roleEntity) {
		RoleResponse roleResponse = new RoleResponse();
		roleResponse.setRoleId(roleEntity.getId());
		roleResponse.setRole(roleEntity.getRole());
		roleResponse.setCreatedBy(roleEntity.getCreatedBy());
		roleResponse.setUpdatedBy(roleEntity.getUpdatedBy());
		return roleResponse;
	}

	public static RoleResponse[] buildRoleResponse(List<RoleEntity> roleEntitylist) {
		List<RoleResponse> roleResponseList = new ArrayList<RoleResponse>();
		for (int i = 0; i < roleEntitylist.size(); i++) {
			RoleResponse roleResponse = new RoleResponse();
			roleResponse.setRoleId(roleEntitylist.get(i).getId());
			roleResponse.setRole(roleEntitylist.get(i).getRole());
			roleResponse.setCreatedBy(roleEntitylist.get(i).getCreatedBy());
			roleResponse.setUpdatedBy(roleEntitylist.get(i).getUpdatedBy());
			roleResponseList.add(roleResponse);
		}
		return roleResponseList.toArray(new RoleResponse[roleResponseList.size()]);

	}

	public static RoleResponse buildRoleResponse(Optional<RoleEntity> roleEntityOpt) {
		RoleResponse roleResponse = new RoleResponse();
		roleResponse.setRoleId(roleEntityOpt.get().getId());
		roleResponse.setRole(roleEntityOpt.get().getRole());
		roleResponse.setCreatedBy(roleEntityOpt.get().getCreatedBy());
		roleResponse.setUpdatedBy(roleEntityOpt.get().getUpdatedBy());
		return roleResponse;

	}

}
