package com.xmh.service;

import java.util.List;

import com.xmh.entity.FoodInfo;
import com.xmh.utils.PageHelper;

public interface MealService {
	boolean insertMeal(FoodInfo foods);
	List<FoodInfo> selectAllMeal();
	boolean updateMeal(FoodInfo foodInfo);
	boolean deleteMeal(Integer mealId);
	PageHelper<FoodInfo> selectAllMealByPage(Integer page);
	boolean submitImg(Integer mealId, String fileString);
	List<FoodInfo> searchByMealName(String mealName, Integer mealSerires);



}
