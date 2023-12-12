package com.jwtTokenPermissionAuth.serviceImpl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.entity.RefreshToken;
import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RefreshTokenRepo;
import com.jwtTokenPermissionAuth.repository.UserRepository;
import com.jwtTokenPermissionAuth.service.RefreshTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
	
	private final UserRepository userRepo;
	
	private final RefreshTokenRepo tokenRepo;
	
	private final long refreshTokenValidity = 365*24*60*60*1000;

	@Override
	public RefreshToken createRefreshToken(User user) {
		
		RefreshToken token = null;
		
		if(user.getRefreshToken() == null) {
		 token = RefreshToken.builder()
					.refreshToken(UUID.randomUUID().toString())
					.expDate(Instant.now().plusMillis(refreshTokenValidity))
					.user(user)
					.build();
		}
		else {
			token = user.getRefreshToken();
			token.setExpDate(Instant.now().plusMillis(refreshTokenValidity));
		}
		
		return tokenRepo.save(token);
	}

	@Override
	public RefreshToken verifyRefreshToken(String refreshToken) throws Exception {
		
		RefreshToken token = tokenRepo.findByRefreshToken(refreshToken).orElseThrow(() -> new Exception("Invelid token"));
		
		if(token.getExpDate().compareTo(Instant.now()) < 0) {
			tokenRepo.deleteById(token.getId());
			throw new Exception("Token has been expired!!");
		}
		return token;
	}

}
