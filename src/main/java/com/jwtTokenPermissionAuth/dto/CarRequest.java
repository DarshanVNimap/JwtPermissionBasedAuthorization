package com.jwtTokenPermissionAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
	
	private String carName;
	private Integer price;
	private String brand;
	

}
