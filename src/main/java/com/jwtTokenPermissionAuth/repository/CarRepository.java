package com.jwtTokenPermissionAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtTokenPermissionAuth.entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{
	
	public Optional<Car> findByCarName(String name);
	
//	public boolean deleteById(Integer id);

}
