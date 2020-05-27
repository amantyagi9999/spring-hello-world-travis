package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.UserDetailEntity;

public interface UserDetailRepo extends JpaRepository<UserDetailEntity, Integer> {

}
