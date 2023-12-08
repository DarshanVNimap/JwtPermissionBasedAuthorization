package com.jwtTokenPermissionAuth.service;

import java.util.List;

import com.jwtTokenPermissionAuth.entity.Role;

public interface RoleService {

	public List<Role> getRoles();

	public Role getRoleById(Integer id) throws Exception;


	public Role addRoleDetail(Role role) throws Exception;

	public Role updateRoleDetail(Role role, Integer id) throws Exception;

	public String removeRoleDetail(Integer id) throws Exception;

}
