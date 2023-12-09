package com.jwtTokenPermissionAuth.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTokenPermissionAuth.dto.RolePermissionRequest;
import com.jwtTokenPermissionAuth.entity.Permission;
import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;
import com.jwtTokenPermissionAuth.repository.PermissionRepository;
import com.jwtTokenPermissionAuth.repository.RolePermissionMapperRepository;
import com.jwtTokenPermissionAuth.repository.RoleRepository;

@RestController
@RequestMapping("/api/v1/rpm")
public class RolePermissionMapperController {
	
	@Autowired
	private RolePermissionMapperRepository mapperRepo;
	
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository repository;
	
	@GetMapping
	public ResponseEntity<?> getAllRoleWithPermission(){
		return ResponseEntity.ok(mapperRepo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> addRoleAndItPermissions(@RequestBody RolePermissionRequest request){
		RolePermissionMapper permissionMapper=new RolePermissionMapper();
		
		Role role=repository.findById(request.getRole()).orElseThrow();
		permissionMapper.setRole(role);
		Permission permission=permissionRepository.findById(request.getPermission()).orElseThrow();
		permissionMapper.setPermission(permission);
		return ResponseEntity.ok(mapperRepo.save(permissionMapper));
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletePermissionOfRole(@RequestBody RolePermissionRequest request){
		
		Role role=repository.findById(request.getRole()).orElseThrow();
		Permission permission=permissionRepository.findById(request.getPermission()).orElseThrow();
		
		RolePermissionMapper map = mapperRepo.findByRoleAndPermission(role, permission);
		
		mapperRepo.deleteById(map.getId());
		
		return ResponseEntity.ok(map);
		
		
	}
	
	

}
