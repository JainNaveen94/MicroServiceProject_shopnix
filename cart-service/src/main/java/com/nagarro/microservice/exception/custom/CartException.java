package com.nagarro.microservice.exception.custom;

@SuppressWarnings("serial")
public class CartException extends RuntimeException {

	public CartException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
