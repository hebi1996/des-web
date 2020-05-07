package com.xmh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmh.service.UserService;


@Controller
public class AdminMainController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping("/adminEditPassword")
	public String adminEditPassword() {
		return "adminEditPassword";
	}
	@RequestMapping("/editAdminPassword")
	@ResponseBody
	public Map<String, String> editAdminPassword(@RequestParam("oldPassword")String oldPassword,@RequestParam("newPassword")String newPassword,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Admin admin = userService.selectAdminByUserId(userId,oldPassword);
		System.out.println(admin);
		if (admin !=null) {
			boolean changePwd = userService.changeAdminPwd(userId,newPassword);
			if (changePwd) {
				map.put("result", "success");
				request.getSession().invalidate();
				return map;
			}
		}
		return null;
	}
	@RequestMapping("/adminFaceRegister")
	public String adminFaceRegister() {
		
		return "adminFaceRegister";
	}
	
}
