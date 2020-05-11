package com.xmh.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Admin {
	private Integer id;
	private String loginName;
	private String loginPwd;
	private String adminType;
	private Long createTime;
	private String showCreateTime; 
	
	public Admin(Integer id, String loginName, String loginPwd, String adminType, Long createTime, String showCreateTime) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.adminType = adminType;
		this.createTime = createTime; 
		this.showCreateTime = showCreateTime;
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

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getShowCreateTime() {
		return showCreateTime;
	}

	public void setShowCreateTime(String showCreateTime) {
		this.showCreateTime = showCreateTime;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
	
}
