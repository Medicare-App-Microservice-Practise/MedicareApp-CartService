package com.medicare.cartservice.Mapper;

import org.mapstruct.Mapper;

import com.medicare.cartservice.dto.CartRequestDto;
import com.medicare.cartservice.dto.CartResponseDto;
import com.medicare.cartservice.entity.Cart;

@Mapper(componentModel="spring")
public interface CartMapper {

	public Cart cartRequestDtoToCart (CartRequestDto cartRequestDto);

	public CartResponseDto cartToCartResponseDto (Cart cart);
	
}
