package com.xmh.service;

import java.util.List;

import com.xmh.entity.Cuisine;
import com.xmh.utils.PageHelper;

public interface MealSeriesService {
	boolean insertMealSeries(Cuisine cuisine);
	List<Cuisine> selectAllSeries();
	boolean updateMealSeriesName(Integer seriesId, String seriesName);
	boolean deleteMealSeries(Integer seriesId);
	PageHelper<Cuisine> selectAllSeriesByPage(Integer page);


}
