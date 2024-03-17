package com.medicare.cartservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_cartItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemId;
	
	private Integer productId;
	
	private String productName;
	
	private String productDescription;
	
	private Integer quantity;
	
	private BigDecimal perUnitPrice;
	
	private BigDecimal totalPrice;
	
	private Boolean isActive;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@PrePersist
	protected void onCreate()
	{
		createdDate = LocalDateTime.now();
		updatedDate = LocalDateTime.now();
		isActive = true;
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		updatedDate = LocalDateTime.now();
	}
	
}
