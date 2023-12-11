package com.jwtTokenPermissionAuth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtTokenPermissionAuth.entity.Permission;
import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;

public interface RolePermissionMapperRepository extends JpaRepository<RolePermissionMapper, Integer> {
	
	public RolePermissionMapper findByRoleAndPermission(Role role , Permission permission);
	public List<RolePermissionMapper> findByRole(Role role);

}
