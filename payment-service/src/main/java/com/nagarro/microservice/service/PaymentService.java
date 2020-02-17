package com.nagarro.microservice.service;

import com.nagarro.microservice.model.ResponseModel;

public interface PaymentService {

	ResponseModel makePayment(long cartId);

}
