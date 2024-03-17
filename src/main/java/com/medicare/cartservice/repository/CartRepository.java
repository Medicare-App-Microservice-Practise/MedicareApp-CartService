package com.medicare.cartservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.cartservice.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("Select c from Cart c where c.customerId=:customerId and c.isActive=:isActive")
	Optional<Cart> findByCustomerActive(@Param("customerId") Integer customerId, @Param("isActive") Boolean isActive);
	
}
