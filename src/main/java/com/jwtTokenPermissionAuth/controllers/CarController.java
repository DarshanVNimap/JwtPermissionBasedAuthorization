package com.jwtTokenPermissionAuth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTokenPermissionAuth.dto.CarRequest;
import com.jwtTokenPermissionAuth.service.Carservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/c")
public class CarController {
	
	private final Carservice carServcie;
	
	@GetMapping
//	@PreAuthorize("hasRole('CAR::READALL')")
	public ResponseEntity<?> getAllCars(){
		return ResponseEntity.
							ok(carServcie.getCars());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('CAR::READBYID')")
	public ResponseEntity<?> getCarById(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(carServcie.getCarById(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getCarByName(@PathVariable(name = "name") String carName) throws Exception{
		return ResponseEntity.
							ok(carServcie.getCarByName(carName));
	}
	
	@PostMapping
	public ResponseEntity<?> saveCar(@RequestBody CarRequest carRequest) throws Exception{
		return ResponseEntity.
							ok(carServcie.addCarDetail(carRequest));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCarDetail(@RequestBody CarRequest carRequest ,@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(carServcie.updateCarDetail(carRequest, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCarDetail(@PathVariable(name = "id") Integer id) throws Exception{
		return ResponseEntity.
							ok(carServcie.removeCarDetail(id));
	}
	
	
	

}
