package com.jwtTokenPermissionAuth.config.securityConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RolePermissionMapperRepository;
import com.jwtTokenPermissionAuth.repository.UserRepository;


public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RolePermissionMapperRepository mapperRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
			
			List<String> permissions = user.getRoles().stream()
			        .flatMap(role -> mapperRepo.findByRole(role).stream().map(r -> r.getPermission().getAction()))
			        .toList();
			
			
		return new CustomeUserDetails(user,permissions);
	}


}
