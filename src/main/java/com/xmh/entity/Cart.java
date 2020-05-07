package com.xmh.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Cart {
	
	private Integer cartId;
	private Integer userId;
	private Integer mealId;
	private Integer count;
	private FoodInfo foodInfo;
	
	
	public Cart(Integer cartId, Integer userId, Integer mealId, Integer count,FoodInfo foodInfo) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.mealId = mealId;
		this.count = count;
		this.foodInfo = foodInfo;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FoodInfo getFoodInfo() {
		return foodInfo;
	}


	public void setFoodInfo(FoodInfo foodInfo) {
		this.foodInfo = foodInfo;
	}


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getMealId() {
		return mealId;
	}


	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", mealId=" + mealId + ", count=" + count
				+ ", foodInfo=" + foodInfo + "]";
	}


	
	
}
