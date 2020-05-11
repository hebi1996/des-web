package com.xmh.entity;

public class SonOrder {
	private Integer odId;
	private Integer oId;
	private Integer mealId;
	private String payType;
	private double mealPrice;
	private double mealCount;
	private FoodInfo foodInfo;
	
	public SonOrder(Integer odId, Integer oId, Integer mealId, String payType, double mealPrice, double mealCount, FoodInfo foodInfo) {
		super();
		this.odId = odId;
		this.oId = oId;
		this.mealId = mealId;
		this.payType = payType;
		this.mealPrice = mealPrice;
		this.mealCount = mealCount;
		this.foodInfo = foodInfo;
	}
	public SonOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodInfo getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(FoodInfo foodInfo) {
		this.foodInfo = foodInfo;
	}
	
	public Integer getOdId() {
		return odId;
	}
	public void setOdId(Integer odId) {
		this.odId = odId;
	}
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	public double getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(double mealPrice) {
		this.mealPrice = mealPrice;
	}
	public double getMealCount() {
		return mealCount;
	}
	public void setMealCount(double mealCount) {
		this.mealCount = mealCount;
	}
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	@Override
	public String toString() {
		return "SonOrder [odId=" + odId + ", oId=" + oId + ", mealId=" + mealId + ", mealPrice=" + mealPrice
				+ ", mealCount=" + mealCount + ", foodInfo=" + foodInfo + "]";
	}
	
	
}
