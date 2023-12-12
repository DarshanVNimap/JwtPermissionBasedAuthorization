package com.jwtTokenPermissionAuth.service;

import com.jwtTokenPermissionAuth.dto.RefreshTokenRequest;
import com.jwtTokenPermissionAuth.dto.TokenResopnse;
import com.jwtTokenPermissionAuth.dto.UserRequest;

public interface AuthenticateService {
	
	public TokenResopnse  registerUser(UserRequest request) ;
	
	public TokenResopnse loginUser(UserRequest request) throws Exception;
	
	public TokenResopnse refresh(RefreshTokenRequest token) throws Exception;

}
