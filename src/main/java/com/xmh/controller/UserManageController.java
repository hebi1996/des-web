package com.xmh.controller;

import java.util.HashMap;
import java.util.Map;

import com.xmh.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.UserService;
import com.xmh.utils.PageHelper;

@Controller
public class UserManageController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/usersManage")
	public ModelAndView usersManage(@Param("page")Integer page) {
		ModelAndView mav = new ModelAndView();
		//List<User> users=userService.selectAllUser();
		PageHelper<User> pageHelper = userService.selectAllUserByPage(page);
		mav.addObject("page",pageHelper);
		mav.setViewName("usersManage");
		
		return mav;
	}
	@RequestMapping("/editUserInfo")
	@ResponseBody
	public Map<String, String> editUserInfo(@RequestParam("id")Integer id,@RequestParam("loginName")String loginName,@RequestParam("loginPwd")String loginPwd,@RequestParam("trueName")String trueName,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address){
		Map<String,String> map = new HashMap<String, String>();
		User user = new User();
		user.setId(id);
		user.setLoginName(loginName);
		user.setLoginPwd(loginPwd);
		user.setTrueName(trueName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		boolean flag=userService.updateUserInfo(user);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
	@RequestMapping("/adminAddUser")
	@ResponseBody
	public Map<String, String> adminAddUser(@RequestParam("loginName")String loginName,@RequestParam("loginPwd")String loginPwd,@RequestParam("trueName")String trueName,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address){
		Map<String,String> map = new HashMap<String, String>();
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPwd(loginPwd);
		user.setTrueName(trueName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		boolean flag = userService.adminAddUser(user);
		if (flag) {
			map.put("result", "success");
			return map;
		}
			
		
		return null;
	}
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Map<String, String> deleteUser(@RequestParam("id")Integer id){
		Map<String,String> map = new HashMap<String, String>();
		boolean flag=userService.deleteUser(id);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
	
	
