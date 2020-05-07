package com.xmh.entity;

public class Cuisine {
	
	private int seriesId;
	private String seriesName;
	
	
	public Cuisine(int seriesId, String seriesName) {
		super();
		this.seriesId = seriesId;
		this.seriesName = seriesName;
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
	@Override
	public String toString() {
		return "Cuisine [seriesId=" + seriesId + ", seriesName=" + seriesName + "]";
	}
	
}
