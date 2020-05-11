package com.xmh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Admin;
import com.xmh.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.UserService;

@Controller
public class AdminManageController {

	@Autowired
	private UserService userSerive;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/adminManage")
	public ModelAndView adminManage(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ModelAndView mav = new ModelAndView();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if(Objects.equals(null, userId)) {
			mav.setViewName("adminlogin");
			return mav;
		}
		List<Admin> admins = userSerive.selectAddAdmin();
		List<Admin> datas = new ArrayList<Admin>();
		Admin adminById = userMapper.selectAdminById(userId);
		for (Admin admin : admins) {
			if(!Objects.equals(
					null, admin.getCreateTime()))  admin.setShowCreateTime(sdf.format(admin.getCreateTime()));
			if(Objects.equals("商户", adminById.getAdminType()) 
					&& Objects.equals("管理员", admin.getAdminType())) continue;
			if (Objects.equals("admin", admin.getLoginName())) {
				continue;
			}
			datas.add(admin);
			
		}
		mav.addObject("admins",datas);
		mav.setViewName("adminManage");
		return mav;
	}
	
	@RequestMapping("/adminAddAdmin")
	@ResponseBody
	public Map<String, String> adminAddAdmin(
			@RequestParam("loginName")String loginName,@RequestParam("loginPwd")String loginPwd, @RequestParam("adminType") String adminType){
		Map<String, String> map = new HashMap<String, String>();
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		admin.setAdminType(adminType);
		admin.setLoginPwd(loginPwd);
		admin.setCreateTime(System.currentTimeMillis());
		boolean flag = userSerive.adminAddAdmin(admin);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
	
	
	@RequestMapping("/admindeleteAdmin")
	@ResponseBody
	public Map<String, String> admindeleteAdmin(@RequestParam("id")Integer id){
		Map<String, String> map = new HashMap<String, String>();
		Admin adminById = userMapper.selectAdminById(id);
		if(Objects.equals(1, id) 
				|| Objects.equals("admin", adminById.getLoginName()))
			return null;
		
		boolean flag = userSerive.admindeleteAdmin(id);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
