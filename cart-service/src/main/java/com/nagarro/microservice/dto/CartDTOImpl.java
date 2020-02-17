package com.nagarro.microservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.microservice.dto.model.CartDTOModel;
import com.nagarro.microservice.dto.model.CartProductDtoModel;
import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.CartProduct;
import com.nagarro.microservice.service.CartService;

@Component
public class CartDTOImpl implements CartDTO {
	
	@Autowired
	private CartService cartService;

	@Override
	public CartDTOModel addProductToCart(long cartId, long prodId) {
		Cart cart = this.cartService.addProductToCart(cartId, prodId);
		return this.createCartDTOModelFromCart(cart);
	}

	private CartDTOModel createCartDTOModelFromCart(Cart cart) {
		CartDTOModel cartDtoModel = new CartDTOModel();
		if(cart != null) {
			cartDtoModel.setId(cart.getId());
			cartDtoModel.setCustomerId(cart.getCustomerId());
			cartDtoModel.setTotalPrice(cart.getTotalPrice());
			cartDtoModel.setCartProducts(this.createCartProductDtoModelListFromaCartProductList(cart.getCartProducts()));
		}
		return cartDtoModel ;
	}

	private List<CartProductDtoModel> createCartProductDtoModelListFromaCartProductList(
			List<CartProduct> cartProducts) {
		List<CartProductDtoModel> cartProductsList = new ArrayList<CartProductDtoModel>();
		if(cartProducts.size() > 0) {
			for(CartProduct cartProductObj: cartProducts) {
				cartProductsList.add(this.createCartProductDtoModelFromCartProduct(cartProductObj));
			}
		}
		return cartProductsList;
	}

	private CartProductDtoModel createCartProductDtoModelFromCartProduct(CartProduct cartProductObj) {
		CartProductDtoModel cartProduct = new CartProductDtoModel();
		cartProduct.setId(cartProductObj.getId());
		cartProduct.setName(cartProductObj.getName());
		cartProduct.setPrice(cartProductObj.getPrice());
		cartProduct.setProdId(cartProductObj.getProdId());
		cartProduct.setQuantity(cartProductObj.getQuantity());
		return cartProduct;
	}

	@Override
	public CartDTOModel deleteProductFromCart(long cartId, long prodId) {
		Cart cart = this.cartService.deleteProductFromCart(cartId, prodId);
		return this.createCartDTOModelFromCart(cart);
	}

	@Override
	public CartDTOModel getCartByCartId(long cartId) {
		Cart cart = this.cartService.getCartByCartId(cartId);
		return this.createCartDTOModelFromCart(cart);
	}
	
	

}
