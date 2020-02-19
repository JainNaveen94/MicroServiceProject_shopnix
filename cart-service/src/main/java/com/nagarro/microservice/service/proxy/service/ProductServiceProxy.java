package com.nagarro.microservice.service.proxy.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.microservice.model.Product;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/product-service/product-service/product/product-id/{prodId}")
	public Product getProductById(@PathVariable("prodId") long prodId);

}
