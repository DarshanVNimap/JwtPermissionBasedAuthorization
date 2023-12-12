package com.jwtTokenPermissionAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResopnse {
	
	private String jwtToken;
	private String refreshToken;
	private Integer userId;
	private String userName;
	private String msg;

}
