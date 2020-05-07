package com.xmh.entity;
public class User {
	private int id;
	private String loginName;
	private String loginPwd;
	private String trueName;
	private String email;
	private String phone;
	private String address;
	private String facepath;
	private Integer integral;
	
	public User(int id, String loginName, String loginPwd, String trueName, String email, String phone, String address,
			String facepath, Integer integral) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.facepath = facepath;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacepath() {
		return facepath;
	}
	public void setFacepath(String facepath) {
		this.facepath = facepath;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		
		return "User [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", trueName=" + trueName
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", facepath=" + facepath + ", integral=" + integral + "]";
	}
	
}
