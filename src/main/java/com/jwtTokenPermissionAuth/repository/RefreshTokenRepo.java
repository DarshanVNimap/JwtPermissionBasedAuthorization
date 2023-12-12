package com.jwtTokenPermissionAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtTokenPermissionAuth.entity.RefreshToken;
import com.jwtTokenPermissionAuth.entity.User;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
	
	public RefreshToken findByUser(User user);
	
	public Optional<RefreshToken> findByRefreshToken(String refreshToken);

}
