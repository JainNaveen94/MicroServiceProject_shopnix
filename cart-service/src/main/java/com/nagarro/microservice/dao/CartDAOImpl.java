package com.nagarro.microservice.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.CartProduct;
import com.nagarro.microservice.repository.CartProductRepository;
import com.nagarro.microservice.repository.CartRepository;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private CartRepository CartRepository;
	
	@Autowired
	private CartProductRepository cartPorductRepository;

	@Override
	public Cart getCartFromCustomerId(long customerId) {
		return this.CartRepository.findByCustomerId(customerId);
	}

	@Override
	public Cart addProductToCart(Cart cart) {
		this.CartRepository.save(cart);
		return cart;
	}

	@Override
	public boolean deleteCartProduct(CartProduct cartProduct) {
		this.cartPorductRepository.delete(cartProduct);
		return true;
	}

	@Override
	public String deleteCartProduct(Cart cart) {
		this.CartRepository.delete(cart);
		return cart.getCustomerId() + " Cart is successfully deleted";
	}

	@Override
	public Cart getCartByCartId(long cartId) {
		return this.CartRepository.findByCustomerId(cartId);
	}

}
