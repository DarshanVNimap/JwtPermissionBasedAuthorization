package com.jwtTokenPermissionAuth.service;

import java.util.List;

import com.jwtTokenPermissionAuth.dto.CarRequest;
import com.jwtTokenPermissionAuth.exceptions.UserNotFoundException;

public interface Carservice {

	public List<CarRequest> getCars();
	
	public CarRequest getCarById(Integer id) throws Exception;
	
	public CarRequest getCarByName(String name) throws UserNotFoundException;
	
	public CarRequest addCarDetail(CarRequest carRequest) throws Exception;
	
	public CarRequest updateCarDetail(CarRequest carRequest , Integer id) throws  Exception;
	
	public String removeCarDetail(Integer id) throws Exception;
	
}
