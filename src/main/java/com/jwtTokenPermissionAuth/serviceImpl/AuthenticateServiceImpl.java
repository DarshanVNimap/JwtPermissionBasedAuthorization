package com.jwtTokenPermissionAuth.serviceImpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.JwtUtils.JwtService;
import com.jwtTokenPermissionAuth.config.securityConfig.CustomeUserDetails;
import com.jwtTokenPermissionAuth.dto.RefreshTokenRequest;
import com.jwtTokenPermissionAuth.dto.TokenResopnse;
import com.jwtTokenPermissionAuth.dto.UserRequest;
import com.jwtTokenPermissionAuth.entity.RefreshToken;
import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RoleRepository;
import com.jwtTokenPermissionAuth.repository.UserRepository;
import com.jwtTokenPermissionAuth.service.AuthenticateService;
import com.jwtTokenPermissionAuth.service.RefreshTokenService;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@Override
	public TokenResopnse registerUser(UserRequest request) {

		User user = modelMapper.map(request, User.class);

		List<Role> roles = new ArrayList<>();
		Role role = roleRepo.findById(1).orElseThrow();

		user.setPassword(passwordEncoder.encode(request.getPassword()));
		roles.add(role);
		user.setRoles(roles);
		userRepo.save(user);
		return TokenResopnse.builder().jwtToken(jwtService.generateToken(new CustomeUserDetails(user)))
				.refreshToken(refreshTokenService.createRefreshToken(user).getRefreshToken()).userId(user.getId())
				.userName(user.getUsername()).msg("Register successfully").build();

	}

	@Override
	public TokenResopnse loginUser(UserRequest request) throws Exception {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		User user = userRepo.findByUsername(request.getUsername())
				.orElseThrow(() -> new UserPrincipalNotFoundException("User not found!!"));

		String jwtToken = jwtService.generateToken(new CustomeUserDetails(user));

		String refreshToken = refreshTokenService.createRefreshToken(user).getRefreshToken();

		return TokenResopnse.builder().jwtToken(jwtToken).refreshToken(refreshToken).userId(user.getId())
				.userName(user.getUsername()).msg("Login successfully").build();
	}

	@Override
	public TokenResopnse refresh(RefreshTokenRequest token) throws Exception {

		RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(token.getRefreshToken());
		User user = refreshToken.getUser();
		return TokenResopnse.builder().jwtToken(jwtService.generateToken(new CustomeUserDetails(user)))
				.refreshToken(refreshTokenService.createRefreshToken(user).getRefreshToken()).userId(user.getId())
				.userName(user.getUsername()).msg("Login successfully").build();

//		return null;
	}

}
