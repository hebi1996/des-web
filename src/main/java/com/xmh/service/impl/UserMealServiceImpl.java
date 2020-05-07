package com.xmh.service.impl;

import java.util.List;

import com.xmh.entity.Cart;
import com.xmh.entity.FoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmh.mapper.UserMealMapper;
import com.xmh.service.UserMealService;
@Service
public class UserMealServiceImpl implements UserMealService{

	@Autowired
	private UserMealMapper userMealMapper;
	
	@Override
	public List<FoodInfo> getAllMeals() {
		// TODO Auto-generated method stub
		return userMealMapper.getAllMeals();
	}

	@Override
	public boolean addMealToCart(Cart cart) {
		return userMealMapper.addMealToCart(cart);
	}

	@Override
	public List<FoodInfo> searchByMealNameAndSeries(String mealName, Integer mealSeries) {
		// TODO Auto-generated method stub
		return userMealMapper.searchByMealNameAndSeries(mealName,mealSeries);
	}

}
