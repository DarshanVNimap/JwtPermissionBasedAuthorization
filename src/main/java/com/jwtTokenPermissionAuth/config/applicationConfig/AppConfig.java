package com.jwtTokenPermissionAuth.config.applicationConfig;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.jwtTokenPermissionAuth.JwtUtils.jwtAuthFilter;
import com.jwtTokenPermissionAuth.config.securityConfig.CustomUserDetailService;

@Configuration
public class AppConfig {
	
	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver exceptionResolver;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public jwtAuthFilter jwtAuthFilter() {
//		return new jwtAuthFilter();
//	}

	@Bean
	public UserDetailsService userDetails() {
		return new CustomUserDetailService();
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider authentication = new DaoAuthenticationProvider();
		authentication.setUserDetailsService(userDetails());
		authentication.setPasswordEncoder(bcryptPassword());

		return authentication;
	}
	
	@Bean
	public jwtAuthFilter jwtAuthenticationFilter() {
		return new jwtAuthFilter(exceptionResolver);
	}
	


}
