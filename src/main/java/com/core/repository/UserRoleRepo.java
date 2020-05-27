package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.UserRoleEntity;

public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {

}
