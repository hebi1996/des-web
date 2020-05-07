package com.xmh.entity;

import java.util.List;
public class UserAndOrders {
	
	private User user;
	private List<SonOrder> orders;
	
	
	public UserAndOrders(User user, List<SonOrder> orders) {
		super();
		this.user = user;
		this.orders = orders;
	}
	public UserAndOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<SonOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<SonOrder> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "UserAndOrders [user=" + user + ", orders=" + orders + "]";
	}
	
}
