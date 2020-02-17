package com.nagarro.microservice.dao;


import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.CartProduct;

public interface CartDAO {

	Cart getCartFromCustomerId(long customerId);

	Cart addProductToCart(Cart cart);

	boolean deleteCartProduct(CartProduct cartProduct);

	String deleteCartProduct(Cart cart);

	Cart getCartByCartId(long cartId);
	
	
}
