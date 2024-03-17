package com.medicare.cartservice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicare.cartservice.response.CartResponse;

@RestControllerAdvice
public class CartException {

	@Autowired
	CartResponse response;

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> dataViolation (NotFoundException ex)
	{
		return response.errorResponse("fail", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
