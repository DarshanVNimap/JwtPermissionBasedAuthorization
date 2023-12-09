package com.jwtTokenPermissionAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionRequest {
	
	private Integer role;
	private Integer permission;

}
