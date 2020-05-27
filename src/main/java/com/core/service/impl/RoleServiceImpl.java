package com.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.entity.RoleEntity;
import com.core.exception.CommonException;
import com.core.manager.RoleManager;
import com.core.repository.RoleRepo;
import com.core.request.RoleRequest;
import com.core.response.RoleResponse;
import com.core.service.RoleService;
import com.core.util.RoleUtil;

@Service
public class RoleServiceImpl implements RoleService {
	private static Logger logger = LogManager.getLogger(RoleServiceImpl.class);

	@Autowired
	RoleRepo roleRepo;

	@Override
	public RoleResponse[] getAllRoles() {
		List<RoleEntity> roleEntityList = roleRepo.findAll();
		return RoleUtil.buildRoleResponse(roleEntityList);
	}

	@Override
	public RoleResponse getRoles(Integer id) throws CommonException {
		Optional<RoleEntity> roleEntityOpt = roleRepo.findById(id);
		if (roleEntityOpt.isPresent()) {
			return RoleUtil.buildRoleResponse(roleEntityOpt);
		} else {
			throw new CommonException("RoleID " + id + " doesn't exist");
		}
	}

	@Override
	public RoleResponse createOrUpdateRole(RoleRequest roleRequest) {

		RoleEntity roleEntity = new RoleEntity();
		if (roleRequest.getId() == null) {
			roleEntity.setRole(roleRequest.getRole());
			roleEntity.setCreatedBy(roleRequest.getCreatedBy());
			roleEntity.setUpdatedBy(roleRequest.getUpdatedBy());
			roleEntity.setDeleted("False");
			roleEntity = roleRepo.save(roleEntity);
			return RoleUtil.buildCreateResponse(roleEntity);
		} else {
			roleEntity = roleRepo.getOne(roleRequest.getId());
			roleEntity.setRole(roleRequest.getRole());
			roleEntity.setUpdatedBy(roleRequest.getUpdatedBy());
			roleEntity.setDeleted("False");
			roleRepo.save(roleEntity);
			return RoleUtil.buildCreateResponse(roleEntity);
		}
	}

	@Override
	public boolean deleteRole(Integer id) throws CommonException {
		Optional<RoleEntity> roleEntityOpt = roleRepo.findById(id);

		if (roleEntityOpt.isPresent()) {
			RoleEntity roleEntity = roleEntityOpt.get();
			roleEntity.setDeleted("True");
			roleRepo.save(roleEntity);
			return true;
		} else {
			throw new CommonException("RoleID " + id + " doesn't exist");
		}

	}

}
