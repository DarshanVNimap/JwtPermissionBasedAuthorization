package com.jwtTokenPermissionAuth.service;

import java.util.List;

import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;

public interface RolePermissionMapperService {
	
	public RolePermissionMapper addRoleAndItsPermission(RolePermissionMapper mapper);
	
	public String removePermissionOfRole(Integer role_id , Integer permission);
	
	public RolePermissionMapper updatePermissionOfRole(RolePermissionMapper mapper , Integer role_id);
	
	public List<RolePermissionMapper> getPermissionsOfAllRole(); 

}
