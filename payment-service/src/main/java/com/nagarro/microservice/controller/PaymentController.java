package com.nagarro.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservice.model.ResponseModel;
import com.nagarro.microservice.service.PaymentService;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payment/cart-id/{cartId}")
	public ResponseEntity<ResponseModel> makePaymentForCart(@PathVariable long cartId) {
		return new ResponseEntity<ResponseModel>(this.paymentService.makePayment(cartId), HttpStatus.OK);
	}
}
