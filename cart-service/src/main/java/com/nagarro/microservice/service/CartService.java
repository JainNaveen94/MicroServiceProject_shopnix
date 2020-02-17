package com.nagarro.microservice.service;

import java.util.List;

import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.CartProduct;

public interface CartService {

	Cart addProductToCart(long cartId, long prodId);

	List<CartProduct> getAllProductOfCart(long cartId);

	Cart deleteProductFromCart(long cartId, long prodId);

	String removeAllProductFromCart(long cartId);

	Cart getCartByCartId(long cartId);

}
