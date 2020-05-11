package com.xmh.entity;

public class Cuisine {
	
	private int seriesId; // 菜系id
	private String seriesName; // 菜系名
	private Integer adminId; // 谁的菜系
	private Long cuisineCreateTime;
	private String adminName;
	private String showCreateTime;
	
	
	public Cuisine(int seriesId, String seriesName, Integer adminId, Long cuisineCreateTime, String adminName, String showCreateTime) {
		super();
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.adminId = adminId;
		this.cuisineCreateTime = cuisineCreateTime;
		this.adminName = adminName;
		this.showCreateTime = showCreateTime;
	}
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Long getCuisineCreateTime() {
		return cuisineCreateTime;
	}
	public void setCuisineCreateTime(Long cuisineCreateTime) {
		this.cuisineCreateTime = cuisineCreateTime;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getShowCreateTime() {
		return showCreateTime;
	}
	public void setShowCreateTime(String showCreateTime) {
		this.showCreateTime = showCreateTime;
	}
	@Override
	public String toString() {
		return "Cuisine [seriesId=" + seriesId + ", seriesName=" + seriesName + "]";
	}
	
}
