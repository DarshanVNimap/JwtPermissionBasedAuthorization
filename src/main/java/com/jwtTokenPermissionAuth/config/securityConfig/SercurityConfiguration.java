package com.jwtTokenPermissionAuth.config.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwtTokenPermissionAuth.JwtUtils.jwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SercurityConfiguration {


	@Autowired
	private AuthenticationProvider authProvider;
	
	@Autowired
	private jwtAuthFilter jwtAuthFilter;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/swagger-ui/index.html#" , "/api/v1/auth/**").permitAll()
						.requestMatchers(HttpMethod.DELETE , "/api/v1/c/**").hasAuthority("car:removeDriver")
						.requestMatchers(HttpMethod.GET , "/api/v1/c/**").hasAuthority("car:view")
						.requestMatchers(HttpMethod.POST , "/api/v1/c/**").hasAuthority("car:create")
						.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
						.anyRequest().authenticated())
				.sessionManagement(
						sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
								.and().authenticationProvider(authProvider)
								.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class));

		return http.build();
	}

}
