package com.jwtTokenPermissionAuth.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.dto.CarRequest;
import com.jwtTokenPermissionAuth.entity.Car;
import com.jwtTokenPermissionAuth.exceptions.CarNotFoundException;
import com.jwtTokenPermissionAuth.exceptions.UserNotFoundException;
import com.jwtTokenPermissionAuth.repository.CarRepository;
import com.jwtTokenPermissionAuth.service.Carservice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements Carservice{
	
	private final CarRepository carRepo;
	
	private final ModelMapper modelMapper;
	

	
	
	@Override
	public List<CarRequest> getCars() {
		
		List<CarRequest> allCars = carRepo.findAll()
										  .stream().map(
												  car -> modelMapper.map(car, CarRequest.class)
												  ).toList();
		
		return allCars;
	}

	public  CarRequest getCarById(Integer id) throws Exception {
		
		Car car = carRepo.findById(id).orElseThrow(()-> new CarNotFoundException("Car not found with id:"+id));
		return modelMapper.map(car, CarRequest.class);
	}

	@Override
	public CarRequest getCarByName(String name) throws UserNotFoundException {
		Car car = carRepo.findByCarName(name).orElseThrow(() -> new CarNotFoundException("Car not found with username: "+name));
		return modelMapper.map(car, CarRequest.class);
	}

	@Override
	public CarRequest addCarDetail(CarRequest carRequest) throws Exception {
		Car car = modelMapper.map(carRequest, Car.class);
		if(carRepo.save(car) != null) 
			return carRequest; 
		else  throw new  Exception("Something went wrong : Details not added!!");
//		return  null ;
	}

	@Override
	public CarRequest updateCarDetail(CarRequest carRequest, Integer id) throws Exception {
		
		carRepo.findById(id).orElseThrow(()-> new CarNotFoundException("Car not found with id:"+id));	
		
		Car updatecar = modelMapper.map(carRequest, Car.class);
		updatecar.setId(id);
		if(carRepo.save(updatecar) != null) 
			return carRequest; 
		else  throw new  Exception("Something went wrong : Details not updated!!");
		
	}

	@Override
	public String removeCarDetail(Integer id) throws Exception {
		carRepo.findById(id).orElseThrow(()-> new CarNotFoundException("Car not found with id:"+id));
		carRepo.deleteById(id);
		return "Detail removed successfully with id: "+id;
	}



}
