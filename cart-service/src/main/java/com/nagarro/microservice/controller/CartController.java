package com.nagarro.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservice.dto.CartDTO;
import com.nagarro.microservice.dto.model.CartDTOModel;
import com.nagarro.microservice.model.CartProduct;
import com.nagarro.microservice.service.CartService;

@RestController
@RequestMapping("/cart-service")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CartDTO cartDto;
	
	@PostMapping("/add-to-cart/cart-id/{cartId}/product-id/{prodId}")
	public ResponseEntity<CartDTOModel> addProductToCart(@PathVariable long cartId, @PathVariable long prodId) {
		CartDTOModel cartDtoModel = this.cartDto.addProductToCart(cartId, prodId);
		return new ResponseEntity<CartDTOModel>(cartDtoModel, HttpStatus.OK);
	}
	
	@GetMapping("/product-list/cart-id/{cartId}")
	public ResponseEntity<List<CartProduct>> getAllProductOfCart(@PathVariable long cartId) {
		return new ResponseEntity<List<CartProduct>>(this.cartService.getAllProductOfCart(cartId), HttpStatus.OK);
	}
	
	@GetMapping("/cart/cart-id/{cartId}")
	public ResponseEntity<CartDTOModel> getCartByCartId(@PathVariable long cartId) {
		CartDTOModel cartDtoModel = this.cartDto.getCartByCartId(cartId);
		return new ResponseEntity<CartDTOModel>(cartDtoModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/add-to-cart/cart-id/{cartId}/product-id/{prodId}")
	public ResponseEntity<CartDTOModel> deleteProductFromCart(@PathVariable long cartId, @PathVariable long prodId) {
		CartDTOModel cartDtoModel = this.cartDto.deleteProductFromCart(cartId, prodId);
		return new ResponseEntity<CartDTOModel>(cartDtoModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove-cart/cart-id/{cartId}")
	public ResponseEntity<String> removeAllProductFromCart(@PathVariable long cartId) {
		return new ResponseEntity<String>(this.cartService.removeAllProductFromCart(cartId), HttpStatus.OK);
	}
}
