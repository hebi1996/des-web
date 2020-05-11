package com.xmh.service;

import java.util.List;

import com.xmh.entity.FoodInfo;
import com.xmh.utils.PageHelper;

public interface MealService {
	/**
	 * 
	 * @param foods
	 * @return
	 */
	boolean insertMeal(FoodInfo foods);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<FoodInfo> selectAllMeal(Integer userId);
	/**
	 * 
	 * @param foodInfo
	 * @return
	 */
	boolean updateMeal(FoodInfo foodInfo);
	/**
	 * 
	 * @param mealId
	 * @return
	 */
	boolean deleteMeal(Integer mealId);
	/**
	 * 
	 * @param page
	 * @param adminId
	 * @return
	 */
	PageHelper<FoodInfo> selectAllMealByPage(Integer page, Integer adminId);
	/**
	 * 
	 * @param mealId
	 * @param fileString
	 * @return
	 */
	boolean submitImg(Integer mealId, String fileString);
	/**
	 * 
	 * @param mealName
	 * @param mealSerires
	 * @return
	 */
	List<FoodInfo> searchByMealName(String mealName, Integer mealSerires);



}
