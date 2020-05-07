package com.xmh.service.impl;

import java.util.List;

import com.xmh.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmh.mapper.CartMapper;
import com.xmh.service.CartService;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public List<Cart> getAllCartsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return cartMapper.getAllCartsByUser(userId);
	}

	@Override
	public boolean deleteCartByCartId(Integer cartId) {
		// TODO Auto-generated method stub
		return cartMapper.deleteCartByCartId(cartId);
	}

	@Override
	public boolean clearMyCart(Integer userId) {
		// TODO Auto-generated method stub
		return cartMapper.clearMyCart(userId);
	}

}
