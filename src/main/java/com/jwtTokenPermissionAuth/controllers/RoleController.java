package com.jwtTokenPermissionAuth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/r")
public class RoleController {
	
	private final RoleService roleService;

	@GetMapping
	public ResponseEntity<?> getAllRoles(){
		return ResponseEntity.
							ok(roleService.getRoles());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(roleService.getRoleById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveRole(@RequestBody Role role) throws Exception{
		return ResponseEntity.
							ok(roleService.addRoleDetail(role));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRoleDetail(@RequestBody Role role ,@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(roleService.updateRoleDetail(role, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoleDetail(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(roleService.removeRoleDetail(id));
	}



}
