package com.xmh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmh.service.UserService;

@Controller
public class UserMainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userEditPassword")
	public String userEditPassword() {
		return "userEditPassword";
	}
	@RequestMapping("/editUserPassword")
	@ResponseBody
	public Map<String, String> editUserPassword(@RequestParam("oldPassword")String oldPassword,@RequestParam("newPassword")String newPassword,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = userService.selectUserByUserIdAndOldPwd(userId,oldPassword);
		System.out.println(user);
		if (user !=null) {
			boolean changePwd = userService.changeUserPwd(userId,newPassword);
			if (changePwd) {
				map.put("result", "success");
				request.getSession().invalidate();
				return map;
			}
		}
		return null;
	}
	
	@RequestMapping("/usersFaceRegister")
	public String usersFaceRegister() {
		return "usersFaceRegister";
	}
	@RequestMapping("/map")
	public String map() {
		return "map";
	}
	

}
