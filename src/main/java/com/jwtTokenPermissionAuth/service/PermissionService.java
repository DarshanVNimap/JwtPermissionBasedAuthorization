package com.jwtTokenPermissionAuth.service;

import java.util.List;

import com.jwtTokenPermissionAuth.entity.Permission;

public interface PermissionService {

	public List<Permission> getPermissions();
	
	public Permission getPermissionById(Integer id) throws Exception;
	
	public Permission addPermissionDetail(Permission permission) throws Exception;
	
	public Permission updatePermissionDetail(Permission permission , Integer id) throws  Exception;
	
	public String removePermisssionDetail(Integer id) throws Exception;
	
}
