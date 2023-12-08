package com.jwtTokenPermissionAuth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rpm")
public class RolePermissionMapperController {

	@GetMapping
	public ResponseEntity<?> getAllRoleWithPermissions(){
		
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRoleWithPermissions(){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> addRoleWithPermissions(){
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRoleWithPermissions(){
		return null;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoleWithPermissions(){
		return null;
	}
	
}
