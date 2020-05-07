package com.xmh.mapper;

import java.util.List;

import com.xmh.entity.Cart;
import com.xmh.entity.FoodInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMealMapper {
	List<FoodInfo> getAllMeals();
	boolean addMealToCart(Cart cart);
	List<FoodInfo> searchByMealNameAndSeries(@Param("mealName") String mealName, @Param("mealSeries") Integer mealSeries);

}
