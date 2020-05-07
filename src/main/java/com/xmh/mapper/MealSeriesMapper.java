package com.xmh.mapper;


import java.util.List;

import com.xmh.entity.Cuisine;
import org.apache.ibatis.annotations.Param;

public interface MealSeriesMapper {
	boolean insertMealSeries(Cuisine cuisine);
	List<Cuisine> selectAllSeries();
	boolean updateMealSeriesName(@Param("seriesId") Integer seriesId, @Param("seriesName") String seriesName);
	boolean deleteMealSeries(@Param("seriesId") Integer seriesId);
	List<Cuisine> selectAllSeriesByPage(@Param("page") Integer page, @Param("size") Integer size);


}
