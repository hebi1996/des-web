package com.xmh.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Admin {
	private Integer id;
	private String loginName;
	private String loginPwd;
	
	public Admin(Integer id, String loginName, String loginPwd) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}

	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
	
}
