package com.jwtTokenPermissionAuth.exceptions;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jwtTokenPermissionAuth.dto.ErrorDto;

@RestControllerAdvice
public class CustomExceptionHandler {
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<?> userNotFoundException(UserNotFoundException ex){
//		return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage() , new Date()));
//	}
//	
//	@ExceptionHandler(CarNotFoundException.class)
//	public ResponseEntity<?> carNotFoundException(CarNotFoundException ex){
//		return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage() , new Date()));
//	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptions(Exception e){
		return ResponseEntity.badRequest().body(new ErrorDto(e.getMessage() , new Date()));
	}

}