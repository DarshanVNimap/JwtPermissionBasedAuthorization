package com.jwtTokenPermissionAuth.config.securityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.entity.RolePermissionMapper;
import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RolePermissionMapperRepository;


public class CustomeUserDetails implements UserDetails {
	
	private final User user;
	
	private RolePermissionMapperRepository repo;
	
//	private List<String> perission;
	
	
	public CustomeUserDetails(User user){
		this.user = user;
	}
	
	
	public CustomeUserDetails(User user, RolePermissionMapperRepository repo) {
	this.user = user;
	this.repo = repo;
}





	private List<SimpleGrantedAuthority> getPermission(User user){
		
		Set<SimpleGrantedAuthority> authorities1 = new HashSet<>();
		
		for(Role role : user.getRoles()) {
			authorities1.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
			for(RolePermissionMapper map : repo.findByRole(role)) {
				authorities1.add(new SimpleGrantedAuthority(map.getPermission().getAction()));
				
				System.out.println(map.getPermission().getAction());
			}
		}
		
		 List<SimpleGrantedAuthority> auth = new ArrayList<>(authorities1);

		
		return auth;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getPermission(user);
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
