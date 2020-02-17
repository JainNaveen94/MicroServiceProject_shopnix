package com.nagarro.microservice.dto;

import com.nagarro.microservice.dto.model.CartDTOModel;

public interface CartDTO {

	CartDTOModel addProductToCart(long cartId, long prodId);

	CartDTOModel deleteProductFromCart(long cartId, long prodId);

	CartDTOModel getCartByCartId(long cartId);

}
