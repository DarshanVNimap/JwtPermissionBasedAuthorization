package com.jwtTokenPermissionAuth.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionRequest {
	
	private Integer role_id;
	private List<Integer> permission_id;

}
