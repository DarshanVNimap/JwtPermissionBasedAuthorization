package com.jwtTokenPermissionAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;

public interface RolePermissionMapperRepository extends JpaRepository<RolePermissionMapper, Integer> {
	
	@Query("delete from RolePermissionMapper where roleid = ?1 and permissionid = ?2")
	public void deletePermissionOfRole(Integer role_id , Integer permission_id);

}
