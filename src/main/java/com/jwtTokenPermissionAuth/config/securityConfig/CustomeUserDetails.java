package com.jwtTokenPermissionAuth.config.securityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtTokenPermissionAuth.entity.User;


public class CustomeUserDetails implements UserDetails {
	
	private final User user;
	
	private List<String> perission;
	
	
	public CustomeUserDetails(User user){
		this.user = user;
	}
	
	
	public CustomeUserDetails(User user2, List<String> permissions) {
		
		this.user = user2;
		this.perission = permissions;
	
	
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
			List<SimpleGrantedAuthority> autherties=new ArrayList<>();
			
			perission.stream()
		    .map(permission -> new SimpleGrantedAuthority("ROLE_" + permission))
		    .forEach(autherties::add);	  
		
		return autherties;
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
