package com.medicare.cartservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(unique=true, nullable=false)
	private Integer customerId;
	
	@Column(nullable=false)
	private LocalDateTime createdDateTime;
	
	@Column(nullable=false)
	private LocalDateTime updateDateTime;
	
	@Column(nullable=false)
	private Boolean isActive;

	@PrePersist
	protected void onCreate()
	{
		createdDateTime = LocalDateTime.now();
		updateDateTime = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		updateDateTime = LocalDateTime.now();
	}
	
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<CartItem> cartItem;
	
}
