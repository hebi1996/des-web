package com.xmh.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.xmh.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.CartService;

@Controller
public class UserCartController {
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/cart")
	public ModelAndView cart(HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		ModelAndView mav = new ModelAndView();
		List<Cart> carts = cartService.getAllCartsByUser(userId);
		System.out.println(carts);
		mav.addObject("carts",carts);
		mav.setViewName("cart");
		return mav;
	}
	@RequestMapping("/deleteCartByCartId")
	@ResponseBody
	public Map<String, String> deleteCartByCartId(@RequestParam("cartId")Integer cartId){
		Map< String, String> map = new HashMap<String, String>();
		boolean flag = cartService.deleteCartByCartId(cartId);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;
	}
	@RequestMapping("/clearMyCart")
	@ResponseBody
	public Map<String, String> clearMyCart(HttpServletRequest request){
		Map< String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		boolean flag = cartService.clearMyCart(userId);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;
	}
	
	
}
