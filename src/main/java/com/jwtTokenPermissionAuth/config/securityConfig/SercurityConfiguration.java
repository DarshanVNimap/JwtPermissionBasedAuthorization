package com.jwtTokenPermissionAuth.config.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SercurityConfiguration {
	
	@Bean
	public BCryptPasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetails() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider authentication = new DaoAuthenticationProvider();
		authentication.setUserDetailsService(userDetails());
		authentication.setPasswordEncoder(bcryptPassword());
		
		return authentication;
	}
	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(request -> 
										request.requestMatchers(HttpMethod.GET).hasAnyRole("ADMIN" , "USER")
										.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
										.anyRequest().authenticated()
								  );
			
		
		return http.build();
	}

}
