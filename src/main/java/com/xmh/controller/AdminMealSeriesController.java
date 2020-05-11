package com.xmh.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Admin;
import com.xmh.entity.Cuisine;
import com.xmh.mapper.UserMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.MealSeriesService;
import com.xmh.service.UserService;
import com.xmh.utils.PageHelper;

@Controller
public class AdminMealSeriesController {
	
	@Autowired
	private MealSeriesService mealSeriesService;
	@Autowired UserMapper userMapper;
	
	@RequestMapping("/mealseriesManage")
	public ModelAndView mealseriesManage(@Param("page")Integer page, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if(Objects.equals(null, userId)) {
			mav.setViewName("adminlogin");
			return mav;
		}
		if(Objects.equals(1, userId)) {
			userId = null;
		}
		PageHelper<Cuisine> pageHelper = mealSeriesService.selectAllSeriesByPage(page, userId);
		List<Cuisine> list = pageHelper.getList();
		for (Cuisine cuisine : list) {
			if (!Objects.equals(null, cuisine.getAdminId())) {
				Admin admin = 
						userMapper.selectAdminById(cuisine.getAdminId());
				if(!Objects.equals(null, admin)) cuisine.setAdminName(admin.getLoginName());
			}
			if(!Objects.equals(null, cuisine.getCuisineCreateTime())) {
				cuisine.setShowCreateTime(sdf.format(cuisine.getCuisineCreateTime()));
			}
		}
		mav.addObject("page",pageHelper);
		mav.setViewName("mealseriesManage");
		return mav;
	}
	 
	@RequestMapping("/addMealSeriesName")
	@ResponseBody
	public Map<String,String> addMealSeriesName(
			@RequestParam("mealseriesName")String mealSeriesName, HttpServletRequest request) {
		System.out.println("添加菜系 ： " + mealSeriesName);
		Map<String,String> map = new HashMap<String, String>();
		Cuisine cuisine = new Cuisine();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		
		if(Objects.equals(null, userId)) {
			return null;
		}
		cuisine.setAdminId(userId);
		cuisine.setSeriesName(mealSeriesName);
		cuisine.setCuisineCreateTime(System.currentTimeMillis());
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
