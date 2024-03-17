package com.medicare.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.cartservice.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

}
