package com.jwtTokenPermissionAuth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTokenPermissionAuth.dto.UserRequest;
import com.jwtTokenPermissionAuth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/u")
public class UserController {
	
	private final UserService userService;

	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.
							ok(userService.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(userService.getUserById(id));
	}
	
	@GetMapping("/name")
	public ResponseEntity<?> getUserByName(@RequestParam(name = "name") String carName) throws Exception{
		return ResponseEntity.
							ok(userService.getUserByName(carName));
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) throws Exception{
		return ResponseEntity.
							ok(userService.addUserDetail(userRequest));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetail(@RequestBody UserRequest userRequest ,@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(userService.updateUserDetail(userRequest, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserDetail(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(userService.removeUserDetail(id));
	}

	
}
