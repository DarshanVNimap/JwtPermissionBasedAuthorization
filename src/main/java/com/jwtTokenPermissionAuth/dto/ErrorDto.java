package com.jwtTokenPermissionAuth.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
	
	private String msg;
	private Date time;
	

}
