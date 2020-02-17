package com.nagarro.microservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservice.model.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
	
	public CartProduct findByProdId(long prodId);

}
