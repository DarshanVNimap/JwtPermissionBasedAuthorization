package com.jwtTokenPermissionAuth.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.exceptions.RoleNotFoundException;
import com.jwtTokenPermissionAuth.repository.RoleRepository;
import com.jwtTokenPermissionAuth.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepo;

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public Role getRoleById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return roleRepo.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));
	}

	@Override
	public Role addRoleDetail(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role updateRoleDetail(Role role, Integer id) throws Exception {
		// TODO Auto-generated method stub
		role.setId(id);
		return roleRepo.save(role);
	}

	@Override
	public String removeRoleDetail(Integer id) throws Exception {

		Role role = roleRepo.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));

		roleRepo.deleteById(id);

		return role.getRole() + " removed!!";
	}

}
