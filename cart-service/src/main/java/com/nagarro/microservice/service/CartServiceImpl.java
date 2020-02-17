package com.nagarro.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.microservice.dao.CartDAO;
import com.nagarro.microservice.exception.custom.CartException;
import com.nagarro.microservice.model.Cart;
import com.nagarro.microservice.model.CartProduct;
import com.nagarro.microservice.model.Product;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDao;
	
	@Autowired
	private ProductServiceProxy productServiceProxy;

	@Override
	public Cart addProductToCart(long cartId, long prodId) {
		Product product = this.productServiceProxy.getProductById(prodId);
		if(product != null && product.getProductQuantity() > 0) {
			CartProduct cartProduct;
			Cart cart = this.cartDao.getCartFromCustomerId(cartId);
			if(cart == null) {
				// Creating new Cart Product
				cartProduct = this.createCartProductFromProduct(product);
				//Creating New Cart
				cart = new Cart();
				cart.setCustomerId(cartId);
				cart.getCartProducts().add(cartProduct);
				cart.setTotalPrice(cartProduct.getPrice());
				cartProduct.setCart(cart);
			} else {
				cartProduct = this.getCartProductFromCartIFExist(cart, prodId);
				if(cartProduct == null) {
					cartProduct = this.createCartProductFromProduct(product);
					cart.getCartProducts().add(cartProduct);
					cart.setTotalPrice(cart.getTotalPrice() + cartProduct.getPrice());
				} else {
					cartProduct.setQuantity(cartProduct.getQuantity() + 1);
					cart.setTotalPrice(cart.getTotalPrice() + cartProduct.getPrice());
				}
			}
			return this.cartDao.addProductToCart(cart);
		} else {
			throw new CartException("Product Is not Exist");
		}
	}
	
	private CartProduct getCartProductFromCartIFExist(Cart cart, long prodId) {
		List<CartProduct> cartProducts = cart.getCartProducts();
		if(cartProducts.size() > 0) {
			for(CartProduct prod: cartProducts) {
				if(prod.getProdId() == prodId) {
					return prod;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	private CartProduct createCartProductFromProduct(Product product) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setName(product.getProductName());
		cartProduct.setPrice(product.getProductPrice());
		cartProduct.setQuantity(1);
		cartProduct.setProdId(product.getProductId());
		return cartProduct;
	}

	@Override
	public List<CartProduct> getAllProductOfCart(long cartId) {
		Cart cart = this.cartDao.getCartFromCustomerId(cartId);
		if(cart != null) {
			return cart.getCartProducts();
		} else {
			throw new CartException("Cart is Not exist with the " + cartId);
		}
	}

	@SuppressWarnings("unused")
	@Override
	public Cart deleteProductFromCart(long cartId, long prodId) {
		Cart cart = this.cartDao.getCartFromCustomerId(cartId);
		if(cart != null) {
			CartProduct cartProduct = this.getCartProductFromCartIFExist(cart, prodId);
			if(cartProduct != null) {
				if(cartProduct.getQuantity() > 1) {
					cartProduct.setQuantity(cartProduct.getQuantity() - 1);
					cart.setTotalPrice(cart.getTotalPrice() - cartProduct.getPrice());
				} else {
					cart.getCartProducts().remove(cartProduct);
					cart.setTotalPrice(cart.getTotalPrice() - cartProduct.getPrice());
					boolean result = this.cartDao.deleteCartProduct(cartProduct);
				}
				return this.cartDao.addProductToCart(cart);
			} else {
				throw new CartException("Product is not exist into the System");
			}
		} else {
			throw new CartException("Cart is Not exist with the " + cartId);
		}
	}

	@Override
	public String removeAllProductFromCart(long cartId) {
		Cart cart = this.cartDao.getCartFromCustomerId(cartId);
		if(cart != null) {
			return this.cartDao.deleteCartProduct(cart);
		} else {
			throw new CartException(cartId + " cart Didn't exist to delete");
		}
	}

	@Override
	public Cart getCartByCartId(long cartId) {
		Cart cart = this.cartDao.getCartByCartId(cartId);
		if(cart != null) {
			return cart;
		}
		return new Cart();
	}

}
