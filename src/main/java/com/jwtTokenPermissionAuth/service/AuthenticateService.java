package com.jwtTokenPermissionAuth.service;

import com.jwtTokenPermissionAuth.dto.UserRequest;

public interface AuthenticateService {
	
	public String  registerUser(UserRequest request) ;
	
	public String loginUser(UserRequest request) throws Exception;

}
