package com.nagarro.microservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.ResponseModel;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private CartServiceProxy cartServerProxy;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	@Override
	public ResponseModel makePayment(long cartId) {
		logger.warn(">>><<<< 1 {}", cartId);
		Cart cart = this.cartServerProxy.getCartByCartId(cartId);
		logger.warn(">>><<<< 2 {}", cart);
		if(cart != null) {
			String checkout = this.cartServerProxy.removeAllProductFromCart(cartId);
			logger.warn(">>><<<< 3 {}", checkout);
			return new ResponseModel(cart, "Successfully-Checkout and Deilvered Soon", true);
		}
		return new ResponseModel(new Cart(), "Cart is Not Available to checkout. please Add Some Product to cart", false);
	}

}
