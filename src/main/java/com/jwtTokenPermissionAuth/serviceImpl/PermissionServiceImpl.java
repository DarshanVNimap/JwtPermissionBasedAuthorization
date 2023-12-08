package com.jwtTokenPermissionAuth.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.entity.Permission;
import com.jwtTokenPermissionAuth.exceptions.PermissionNotFoundException;
import com.jwtTokenPermissionAuth.repository.PermissionRepository;
import com.jwtTokenPermissionAuth.service.PermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
	
	private final PermissionRepository permissionRepo;

	@Override
	public List<Permission> getPermissions() {
 
		return permissionRepo.findAll();
	}

	@Override
	public Permission getPermissionById(Integer id) throws Exception {
 
		return permissionRepo.findById(id).orElseThrow(() -> new PermissionNotFoundException("Permission not found with id: " + id));
	}

	@Override
	public Permission addPermissionDetail(Permission permission) throws Exception {
 
		return permissionRepo.save(permission);
	}

	@Override
	public Permission updatePermissionDetail(Permission permission, Integer id) throws Exception {
 
		permission.setId(id);
		return permissionRepo.save(permission);
	}


	@Override
	public String removePermisssionDetail(Integer id) throws Exception {
		Permission permission = permissionRepo.findById(id).orElseThrow(() -> new PermissionNotFoundException("Permission not found with id: " + id));
		
		permissionRepo.deleteById(id);
		return permission.getAction()+" removed!!";
	}

}
