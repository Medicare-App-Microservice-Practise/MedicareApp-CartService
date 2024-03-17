package com.medicare.cartservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {

	private Integer cartItemId;
	
	private Integer cartId;
	
	private Integer customerId;
	
	private Integer productId;
	
	private String productName;
	
	private String productDescription;
	
	private Integer quantity;
	
	private BigDecimal perUnitPrice;
	
	private BigDecimal totalPrice;
	
}
