package com.medicare.cartservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
	
	private Integer productId;
	
	private Integer customerId;
	
	private String productName;
	
	private String productDescription;
	
	private Integer quantity;
	
	private BigDecimal perUnitPrice;
	
	
}
