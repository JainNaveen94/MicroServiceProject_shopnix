package com.nagarro.microservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.microservice.model.Cart;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "cart-service")
public interface CartServiceProxy {
	
	@GetMapping("/cart-service/cart-service/cart/cart-id/{cartId}")
	public Cart getCartByCartId(@PathVariable long cartId) ;
	
	@DeleteMapping("/cart-service/cart-service/remove-cart/cart-id/{cartId}")
	public String removeAllProductFromCart(@PathVariable long cartId);

}
