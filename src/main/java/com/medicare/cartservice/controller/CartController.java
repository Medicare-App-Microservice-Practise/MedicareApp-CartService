package com.medicare.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.cartservice.dto.CartRequestDto;
import com.medicare.cartservice.dto.CartResponseDto;
import com.medicare.cartservice.dto.ProductCartResponseDto;
import com.medicare.cartservice.dto.ViewCartDto;
import com.medicare.cartservice.exception.NotFoundException;
import com.medicare.cartservice.response.CartResponse;
import com.medicare.cartservice.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService service;
	
	@Autowired
	CartResponse response;

	
	@PostMapping("")
	public ResponseEntity<Object> addToCart (@RequestBody CartRequestDto cartRequestDto){
		
		if(service.addToCart(cartRequestDto))
		{
			return response.responseWithoutData("success", HttpStatus.CREATED);
		}else
		{
			return response.errorResponse("error", "Unable to create cart", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> viewAllCart (@PathVariable int customerId) throws NotFoundException
	{
		List<CartResponseDto> cartResponse = service.viewAllCart(customerId);
		
		return response.responseWithListData("success", cartResponse, HttpStatus.OK);
	}
	
	
	
	
	// DELETE BY CART ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCartItemById(@PathVariable int id)
	{
		service.deleteCartItemById(id);
		return response.responseWithoutData("success", HttpStatus.OK);
	}
	
}
