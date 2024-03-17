package com.medicare.cartservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartResponseDto {

	 private Integer productId;

	 private String productName;
	 
	 private BigDecimal sellingPrice;
	 
	 private Integer stockQuantity;

	 private String description;

	private String imageUrl;
	
}
