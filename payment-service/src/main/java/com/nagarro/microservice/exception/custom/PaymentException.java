package com.nagarro.microservice.exception.custom;

@SuppressWarnings("serial")
public class PaymentException extends RuntimeException {

	public PaymentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PaymentException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PaymentException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
}
