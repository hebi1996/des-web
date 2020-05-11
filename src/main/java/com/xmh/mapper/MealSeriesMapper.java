package com.xmh.mapper;


import java.util.List;

import com.xmh.entity.Cuisine;
import org.apache.ibatis.annotations.Param;

public interface MealSeriesMapper {
	boolean insertMealSeries(Cuisine cuisine);
	/**
	 * 查询用户所有的菜系
	 * @return
	 */
	List<Cuisine> selectAllSeries(@Param("adminId") Integer adminId);
	boolean updateMealSeriesName(@Param("seriesId") Integer seriesId, @Param("seriesName") String seriesName);
	boolean deleteMealSeries(@Param("seriesId") Integer seriesId);
	/**
	 * 
	 * @param adminId
	 * @param page
	 * @param size
	 * @return
	 */
	List<Cuisine> selectAllSeriesByPage(@Param("adminId") Integer adminId, @Param("page") Integer page, @Param("size") Integer size);


}
