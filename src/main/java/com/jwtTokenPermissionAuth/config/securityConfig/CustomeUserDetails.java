package com.jwtTokenPermissionAuth.config.securityConfig;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RolePermissionMapperRepository;

public class CustomeUserDetails implements UserDetails {

	private User user;

	@Autowired
	private RolePermissionMapperRepository mapperRepo;

	public CustomeUserDetails(User user) {
		super();
		this.user = user;
	}

	private List<SimpleGrantedAuthority> getRolesAndPermissions(User user) {
		
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getRole())
				)
				.collect(Collectors.toList());
		
		

		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRolesAndPermissions(user);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
