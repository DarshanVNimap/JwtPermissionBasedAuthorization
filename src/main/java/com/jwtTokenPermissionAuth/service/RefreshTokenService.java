package com.jwtTokenPermissionAuth.service;

import com.jwtTokenPermissionAuth.entity.RefreshToken;
import com.jwtTokenPermissionAuth.entity.User;

public interface RefreshTokenService {
	
	public RefreshToken createRefreshToken(User user);
	
	public RefreshToken verifyRefreshToken(String refreshToken) throws Exception ;

}
