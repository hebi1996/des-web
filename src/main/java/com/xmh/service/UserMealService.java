package com.xmh.service;

import com.xmh.entity.Cart;
import com.xmh.entity.FoodInfo;

import java.util.List;

public interface UserMealService {
	List<FoodInfo> getAllMeals();
	boolean addMealToCart(Cart cart);
	List<FoodInfo> searchByMealNameAndSeries(String mealName, Integer mealSeries);

}
