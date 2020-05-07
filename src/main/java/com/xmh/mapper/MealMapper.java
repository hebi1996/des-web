package com.xmh.mapper;

import com.xmh.entity.FoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MealMapper {
	boolean insertMeal(FoodInfo foods);
	List<FoodInfo> selectAllMeal();
	boolean updateMeal(FoodInfo foodInfo);
	boolean deleteMeal(@Param("mealId") Integer mealId);
	List<FoodInfo> selectAllMealByPage(@Param("page") Integer page, @Param("size") Integer size);
	boolean submitImg(@Param("mealId") Integer mealId, @Param("file") String fileString);
	List<FoodInfo> searchByMealName(@Param("mealName") String mealName, @Param("mealSeries") Integer mealSerires);


}
