package com.nagarro.microservice.model;

public class ResponseModel {
	
	private Cart cart;
	private String paymentStatus;
	private boolean status;
	
	
	public ResponseModel() {
		// TODO Auto-generated constructor stub
	}


	public ResponseModel(Cart cart, String paymentStatus, boolean status) {
		super();
		this.cart = cart;
		this.paymentStatus = paymentStatus;
		this.status = status;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

}
