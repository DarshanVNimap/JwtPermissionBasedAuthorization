package com.jwtTokenPermissionAuth.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;
import com.jwtTokenPermissionAuth.repository.RolePermissionMapperRepository;
import com.jwtTokenPermissionAuth.service.RolePermissionMapperService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolePermissionMapperServiceImpl implements RolePermissionMapperService{
	
	private final RolePermissionMapperRepository mapperRepo;

	@Override
	public RolePermissionMapper addRoleAndItsPermission(RolePermissionMapper mapper) {
		
		return mapperRepo.save(mapper);
	}

	@Override
	public String removePermissionOfRole(Integer role_id, Integer permission) {
		return null;
	}

	@Override
	public RolePermissionMapper updatePermissionOfRole(RolePermissionMapper mapper, Integer role_id) {
		
		return null;
	}

	@Override
	public List<RolePermissionMapper> getPermissionsOfAllRole() {
		return null;
	}

}
