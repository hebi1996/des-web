package com.xmh.service.impl;

import java.util.List;

import com.xmh.entity.FoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmh.mapper.MealMapper;
import com.xmh.service.MealService;
import com.xmh.utils.PageHelper;
@Service
public class MealServiceImpl implements MealService{

	@Autowired
	private MealMapper mealMapper;
	@Autowired
	private PageHelper<FoodInfo> pageHelper;
	
	@Override
	public boolean insertMeal(FoodInfo foods) {
		// TODO Auto-generated method stub
		return mealMapper.insertMeal(foods);
	}

	@Override
	public List<FoodInfo> selectAllMeal() {
		// TODO Auto-generated method stub
		return mealMapper.selectAllMeal();
	}

	@Override
	public boolean updateMeal(FoodInfo foodInfo) {
		// TODO Auto-generated method stub
		return mealMapper.updateMeal(foodInfo);
	}

	@Override
	public boolean deleteMeal(Integer mealId) {
		// TODO Auto-generated method stub
		return mealMapper.deleteMeal(mealId);
	}

	@Override
	public PageHelper<FoodInfo> selectAllMealByPage(Integer page) {
		//page����С��1
		if (page<=1) {
			page = 1;
		}
		//���浱ǰҳ
		pageHelper.setNow_page(page);
		List<FoodInfo> totalUsers = mealMapper.selectAllMeal();
		Integer size = pageHelper.getSize();
		List<FoodInfo> foodInfos = mealMapper.selectAllMealByPage((page-1)*size,size);
		//�ܼ�¼��
		pageHelper.setCounts(totalUsers.size());
		
		//��ҳ����
		pageHelper.setList(foodInfos);
		//��ҳ��
		int total = pageHelper.getPage_total();
		if (page>1) {
			pageHelper.setPrev(true);
			
		}else {
			pageHelper.setPrev(false);
		}
		if (page<total) {
			pageHelper.setNext(true);
			
		}else {
			pageHelper.setNext(false);
		}
		return pageHelper;
	}
	@Override
	public boolean submitImg(Integer mealId, String fileString) {
		// TODO Auto-generated method stub
		return mealMapper.submitImg(mealId,fileString);
	}

	@Override
	public List<FoodInfo> searchByMealName(String mealName, Integer mealSerires) {
		// TODO Auto-generated method stub
		return mealMapper.searchByMealName(mealName,mealSerires);
	}

}
