package com.core.service;

import com.core.exception.CommonException;
import com.core.request.RoleRequest;
import com.core.response.RoleResponse;

public interface RoleService {

	public RoleResponse[] getAllRoles() throws CommonException;

	public RoleResponse getRoles(Integer id) throws CommonException;

	public RoleResponse createOrUpdateRole(RoleRequest roleRequest) throws CommonException;

	public boolean deleteRole(Integer id) throws CommonException;

}
