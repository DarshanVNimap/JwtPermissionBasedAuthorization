package com.jwtTokenPermissionAuth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTokenPermissionAuth.dto.RefreshTokenRequest;
import com.jwtTokenPermissionAuth.dto.UserRequest;
import com.jwtTokenPermissionAuth.service.AuthenticateService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticateController {
	
	@Autowired
	private AuthenticateService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest){
		
		return ResponseEntity.ok(authService.registerUser(userRequest));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody UserRequest userRequest) throws Exception{
		try {
		return ResponseEntity.ok(authService.loginUser(userRequest));
		}
		catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@PostMapping("/generateToken")
	public ResponseEntity<?> authRefreshToken(@RequestBody RefreshTokenRequest tokenRequest) throws Exception{
		return ResponseEntity.ok(authService.refresh(tokenRequest));
				
	}

}
