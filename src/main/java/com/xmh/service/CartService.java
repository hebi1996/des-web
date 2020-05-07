package com.xmh.service;

import com.xmh.entity.Cart;

import java.util.List;

public interface CartService {
	List<Cart> getAllCartsByUser(Integer userId);
	
	/**
	 * ɾ���ҵĹ��ﳵ�еĶ���
	 * @param cartId
	 * @return
	 */
	boolean deleteCartByCartId(Integer cartId);
	
	/**
	 * ��չ��ﳵ
	 * @param userId
	 * @return
	 */
	boolean clearMyCart(Integer userId);

}
