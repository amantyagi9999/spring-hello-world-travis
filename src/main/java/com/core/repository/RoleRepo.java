package com.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.core.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
	
	@Query(value = "select re from RoleEntity re where re.id= ?1 and re.deleted = 'False'")
	Optional<RoleEntity> findById(Integer id);

}
