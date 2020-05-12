package com.xmh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Cart;
import com.xmh.entity.FoodInfo;
import com.xmh.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.UserMealService;
import com.xmh.service.UserService;

@Controller
public class UserMealController {
	@Autowired
	private UserMealService userMealService;
	
	@RequestMapping("/meal")
	public ModelAndView meal(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String loginName = (String) request.getSession().getAttribute("loginName");
		String loginPwd = (String) request.getSession().getAttribute("loginPwd");
		System.out.println(loginName);
		System.out.println(loginPwd);
		List<FoodInfo> foodInfos = userMealService.getAllMeals();
		for (FoodInfo fdi : foodInfos) {
			String mealAllImage = fdi.getMealImage();
			if (mealAllImage!=null) {
				String mealImage = mealAllImage.substring(mealAllImage.lastIndexOf("\\")+1);
				fdi.setMealImage(mealImage);
			}
	
		}
		mav.addObject("foods",foodInfos);
		mav.setViewName("meal");
		return mav;
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addMealToCart")
	@ResponseBody
	public Map<String, String > addMealToCart(@RequestParam("mealId")Integer mealId,@RequestParam("count")Integer count,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = userService.userInfoByUserId(userId);
		if(user.getIntegral() < 70) {
		map.put("result", "积分不够70不能进行加入购物车操作！");
		return map;
		}
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setMealId(mealId);
		cart.setCount(count);
		boolean flag = userMealService.addMealToCart(cart);
		if (flag) {
			map.put("result", "已加入购物车");
			return map;
		}
		return null;
	}
	@RequestMapping("/searchByMealName")
	public ModelAndView searchByMealName(@Param("mealName")String mealName,@Param("mealSeries")Integer mealSeries) {
		
		ModelAndView mav = new ModelAndView();
		List<FoodInfo> foodInfos = userMealService.searchByMealNameAndSeries(mealName,mealSeries);
		for (FoodInfo fdi : foodInfos) {
			String mealAllImage = fdi.getMealImage();
			if (mealAllImage!=null) {
				String mealImage = mealAllImage.substring(mealAllImage.lastIndexOf("\\")+1);
				fdi.setMealImage(mealImage);
			}
		}
		mav.addObject("meals",foodInfos);
		mav.addObject("series",mealSeries);
		mav.setViewName("searchmeal");
		return mav;
	}

	
		

	
}
