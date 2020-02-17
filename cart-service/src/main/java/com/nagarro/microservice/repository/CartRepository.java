package com.nagarro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservice.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	public Cart findByCustomerId(long customerId);

}
