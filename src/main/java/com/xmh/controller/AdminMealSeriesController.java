package com.xmh.controller;

import java.util.HashMap;
import java.util.Map;

import com.xmh.entity.Cuisine;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.MealSeriesService;
import com.xmh.utils.PageHelper;

@Controller
public class AdminMealSeriesController {
	
	@Autowired
	private MealSeriesService mealSeriesService;
	
	@RequestMapping("/mealseriesManage")
	public ModelAndView mealseriesManage(@Param("page")Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper<Cuisine> pageHelper = mealSeriesService.selectAllSeriesByPage(page);
		mav.addObject("page",pageHelper);
		//List<Cuisine> cuisines = mealSeriesService.selectAllSeries();
		//mav.addObject("cuisines",cuisines);
		mav.setViewName("mealseriesManage");
		return mav;
	}
	
	
//	@RequestMapping("/getAllSeries")
//	@ResponseBody
//	public List<Cuisine> getSeries(@RequestParam("page") Integer page) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("result", "�µ�");
//		List<Cuisine> cuisines = mealSeriesService.selectAllSeries();
//		return cuisines;
//	}
	 
	@RequestMapping("/addMealSeriesName")
	@ResponseBody
	public Map<String,String> addMealSeriesName(@RequestParam("mealseriesName")String mealSeriesName) {
		System.out.println(mealSeriesName);
		Map<String,String> map = new HashMap<String, String>();
		Cuisine cuisine = new Cuisine();
		cuisine.setSeriesName(mealSeriesName);
		boolean flag= mealSeriesService.insertMealSeries(cuisine);
		if (flag) {
			map.put("success", "1");
			return map;
		}
		return null;
	}
	
	@RequestMapping("/editMealSeries")
	@ResponseBody
	public Map<String,String> editMealSeries(@RequestParam("seriesName")String seriesName,@RequestParam("seriesId")Integer seriesId) {
			Map<String,String> map = new HashMap<String, String>();
			boolean flag=mealSeriesService.updateMealSeriesName(seriesId,seriesName);
			if (flag) {
				map.put("result", "success");
				return map;
			}
			return null;
	}
	@RequestMapping("/deleteMealSeries")
	@ResponseBody
	public Map<String,String> deleteMealSeries(@RequestParam("seriesId")Integer seriesId){
		Map<String,String> map = new HashMap<String, String>();
		boolean flag=mealSeriesService.deleteMealSeries(seriesId);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
