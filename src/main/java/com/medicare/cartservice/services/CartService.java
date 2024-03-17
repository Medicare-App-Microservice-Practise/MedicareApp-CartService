package com.medicare.cartservice.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medicare.cartservice.Mapper.CartMapper;
import com.medicare.cartservice.dto.CartRequestDto;
import com.medicare.cartservice.dto.CartResponseDto;
import com.medicare.cartservice.dto.ProductCartResponseDto;
import com.medicare.cartservice.dto.ResponseDto;
import com.medicare.cartservice.entity.Cart;
import com.medicare.cartservice.entity.CartItem;
import com.medicare.cartservice.exception.NotFoundException;
import com.medicare.cartservice.repository.CartItemRepository;
import com.medicare.cartservice.repository.CartRepository;

@Service
public class CartService {

	private static final Logger logger = Logger.getAnonymousLogger();
	
	@Autowired 
	CartRepository repo;
	
	@Autowired
	CartItemRepository cartItemRepo;
	
	@Autowired
	CartMapper mapper;
	
	@Autowired
	RestTemplate temp;
	
	
	
	public Boolean addToCart(CartRequestDto cartRequestDto)
	{
		Optional<Cart> existingCart = repo.findByCustomerActive(cartRequestDto.getCustomerId(), true);
		
		Cart cart;
		if(existingCart.isPresent())
		{
			cart = existingCart.get();
		}else {
			cart = new Cart();
			cart.setCustomerId(cartRequestDto.getCustomerId());
			cart.setIsActive(true);
		}
		
		cart = repo.save(cart);
		
		CartItem cartItem = new CartItem();
		
		cartItem.setCart(cart);
		cartItem.setProductId(cartRequestDto.getProductId());
		cartItem.setProductName(cartRequestDto.getProductName());
		cartItem.setProductDescription(cartRequestDto.getProductDescription());
		cartItem.setQuantity(cartRequestDto.getQuantity());
		cartItem.setPerUnitPrice(cartRequestDto.getPerUnitPrice());
		
		BigDecimal total =calculateTotalPrice(cartRequestDto.getPerUnitPrice(),cartRequestDto.getQuantity());
		cartItem.setTotalPrice(total);

		if(cartItemRepo.save(cartItem) != null ) {
			return true;
		}else {
			return false;
		}

	}
	
	public List<CartResponseDto> viewAllCart(int customerId) throws NotFoundException
	{
		Optional<Cart> existingCart = repo.findByCustomerActive(customerId, true);
		
		if(existingCart.isPresent())
		{
			List<CartItem> cartItems = existingCart.get().getCartItem();
			
			List<CartResponseDto> cartResponse = new ArrayList<>();
			
			for(CartItem cart : cartItems)
			{
				CartResponseDto dto = new CartResponseDto();
				
				dto.setCustomerId(cart.getCart().getCustomerId());
				dto.setCartId(cart.getCart().getCartId());
				dto.setCartItemId(cart.getCartItemId());
				dto.setProductId(cart.getProductId());
				dto.setProductName(cart.getProductName());
				dto.setProductDescription(cart.getProductDescription());
				dto.setQuantity(cart.getQuantity());
				dto.setPerUnitPrice(cart.getPerUnitPrice());
				dto.setTotalPrice(cart.getTotalPrice());
				
				cartResponse.add(dto);
			}
			logger.info(cartResponse.toString());
			return cartResponse;
			
		}
		else {
			throw new NotFoundException("No Cart Found");
		}
	}
	

	
	public void deleteCartItemById(int id)
	{
		cartItemRepo.deleteById(id);
	}
	
	public BigDecimal calculateTotalPrice(BigDecimal unitPrice, Integer quantity) {
		
		BigDecimal totalPrice = unitPrice.multiply(new BigDecimal(quantity));
		return totalPrice;
	}
	
	
//	public ProductCartResponseDto getProductInfo(int productID)
//	{
//		String url = "http://localhost:8091/api/v1/product/getProductCart/"+productID;
//		
//		ResponseEntity<ResponseDto> responseService = temp.getForEntity(url, ResponseDto.class);
//		
//		ResponseDto responseBody = responseService.getBody();
//		
//		ProductCartResponseDto productCartResponseDto = responseBody.getData();
//		
//		return productCartResponseDto;
//	}
}
