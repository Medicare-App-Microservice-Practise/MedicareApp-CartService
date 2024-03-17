package com.medicare.cartservice.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CartResponse {

	public ResponseEntity<Object> responseWithoutData (String result, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", result);
		
		return new ResponseEntity<>(response, httpStatus);
	}
	
	public ResponseEntity<Object> responseWithData (String result, Object object, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", result);
		response.put("data", object);
		
		return new ResponseEntity<>(response, httpStatus);
	}
	
	public ResponseEntity<Object> responseWithListData (String result, List<?> dataList, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", result);
		response.put("data", dataList);
		
		return new ResponseEntity<>(response, httpStatus);
	}
	
	public ResponseEntity<Object> errorResponse (String result, String messsage, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", result);
		response.put("messsage", messsage);
		
		return new ResponseEntity<>(response, httpStatus);
	}
	
}
