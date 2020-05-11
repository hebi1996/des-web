package com.xmh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmh.entity.Admin;
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
	
	@RequestMapping("/adminManage")
	public ModelAndView adminManage() {
		ModelAndView mav = new ModelAndView();
		List<Admin> admins = userSerive.selectAddAdmin();
		mav.addObject("admins",admins);
		mav.setViewName("adminManage");
		return mav;
	}
	
	@RequestMapping("/adminAddAdmin")
	@ResponseBody
	public Map<String, String> adminAddAdmin(@RequestParam("loginName")String loginName,@RequestParam("loginPwd")String loginPwd){
		Map<String, String> map = new HashMap<String, String>();
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		admin.setLoginPwd(loginPwd);
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
		boolean flag = userSerive.admindeleteAdmin(id);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
