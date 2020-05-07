package com.xmh.mapper;

import java.util.List;

import com.xmh.entity.Cart;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
	List<Cart> getAllCartsByUser(@Param("userId") Integer userId);
	boolean deleteCartByCartId(@Param("cartId") Integer cartId);
	boolean clearMyCart(@Param("userId") Integer userId);
}
