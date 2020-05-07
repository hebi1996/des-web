package com.xmh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmh.entity.Cuisine;
import com.xmh.entity.FoodInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.MealSeriesService;
import com.xmh.service.MealService;

@Controller
public class AdminMealController {
	
	@Autowired
	private MealService mealService;
	@Autowired
	private MealSeriesService mealSeriesService;
	
	@RequestMapping("/mealManage")
	public ModelAndView mealManage(@Param("page")Integer page) {
		ModelAndView mav = new ModelAndView();
		//PageHelper<FoodInfo> pageHelper = mealService.selectAllMealByPage(page);
		//List<FoodInfo> list = pageHelper.getList();
		//mav.addObject("page",pageHelper);
		//mav.addObject("list",list);
		List<FoodInfo> foodInfos = mealService.selectAllMeal();	
		mav.addObject("meals",foodInfos);
		mav.setViewName("mealManage");
		return mav;
	}
	
	@RequestMapping("/addMealName")
	@ResponseBody
	public Map<String,String> addMealName(@RequestParam("mealName")String mealName,@RequestParam("mealSummarize")String mealSummarize,@RequestParam("mealDescription")String mealDescription,@RequestParam("mealPrice")double mealPrice,@RequestParam("mealSeriesId")Integer mealSeriesId) {
		System.out.println(mealName+mealSummarize+mealDescription+mealPrice+mealSeriesId);
		Map<String,String> map = new HashMap<String, String>();
		FoodInfo foods=new FoodInfo();
		foods.setMealDescription(mealDescription);
		foods.setMealName(mealName);;
		foods.setMealPrice(mealPrice);
		foods.setMealSeriesId(mealSeriesId);
		foods.setMealSummarize(mealSummarize);
		boolean flag=mealService.insertMeal(foods);
		if (flag) {
			map.put("result", "1");
			return map;
		}
		return null;
	}
	
	@RequestMapping("/editMealName")
	@ResponseBody
	public Map<String,String> editMealName(@RequestParam("mealId")Integer mealId,@RequestParam("mealName")String mealName,@RequestParam("mealSummarize")String mealSummarize,@RequestParam("mealDescription")String mealDescription,@RequestParam("mealPrice")double mealPrice,@RequestParam("mealSeriesId")Integer mealSeriesId){
		Map<String,String> map = new HashMap<String, String>();
		FoodInfo foodInfo = new FoodInfo();
		foodInfo.setMealId(mealId);
		foodInfo.setMealName(mealName);
		foodInfo.setMealSummarize(mealSummarize);
		foodInfo.setMealDescription(mealDescription);
		foodInfo.setMealPrice(mealPrice);
		foodInfo.setMealSeriesId(mealSeriesId);

		boolean flag=mealService.updateMeal(foodInfo);
		if (flag) {
			map.put("result", "1");
			return map;
		}
		
		return null;
	}
	@RequestMapping("/deleteMeal")
	@ResponseBody
	public Map<String,String> deleteMeal(@RequestParam("mealId")Integer mealId){
		Map<String,String> map = new HashMap<String, String>();
		boolean flag = mealService.deleteMeal(mealId);
		if (flag) {
			map.put("result", "1");
			return map;
		}
		
		return null;
	}
	@RequestMapping("/getAllSeries")
	@ResponseBody
	public List<Cuisine> getAllSeries(){
		List<Cuisine> cuisines = mealSeriesService.selectAllSeries();

		return cuisines;
	}
	@RequestMapping("/adminSearchByMealName")
	public ModelAndView searchByMealName(@RequestParam("mealName")String mealName,@RequestParam("mealSerires")Integer mealSerires){
		ModelAndView mav = new ModelAndView();
		List<FoodInfo> foodInfos = mealService.searchByMealName(mealName,mealSerires);
		mav.addObject("meals",foodInfos);
		mav.addObject("mealSeries",mealSerires);
		mav.setViewName("adminSearchByMealName");
		return mav;
	}
}
