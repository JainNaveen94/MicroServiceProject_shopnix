package com.nagarro.microservice.dto.model;

import java.util.ArrayList;
import java.util.List;


public class CartDTOModel {
	
	private long id;
	private long customerId;
	private float totalPrice;
	private List<CartProductDtoModel> cartProducts;
	
	public CartDTOModel() {
		this.cartProducts = new ArrayList<CartProductDtoModel>();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartProductDtoModel> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProductDtoModel> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
