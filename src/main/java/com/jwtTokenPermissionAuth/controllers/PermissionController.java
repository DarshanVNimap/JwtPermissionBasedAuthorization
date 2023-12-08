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

import com.jwtTokenPermissionAuth.entity.Permission;
import com.jwtTokenPermissionAuth.service.PermissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/p")
public class PermissionController {
	
	private final PermissionService permissionService;

	@GetMapping
	public ResponseEntity<?> getAllPermissions(){
		return ResponseEntity.
							ok(permissionService.getPermissions());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(permissionService.getPermissionById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> savePermission(@RequestBody Permission permission) throws Exception{
		return ResponseEntity.
							ok(permissionService.addPermissionDetail(permission));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePermissionDetail(@RequestBody Permission permission ,@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(permissionService.updatePermissionDetail(permission, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePermissionDetail(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(permissionService.removePermisssionDetail(id));
	}


}
