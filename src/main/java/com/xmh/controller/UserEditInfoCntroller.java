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
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.UserService;

@Controller
public class UserEditInfoCntroller {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/editUser")
	public ModelAndView editUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = userService.userInfoByUserId(userId);
		mav.addObject("user",user);
		mav.setViewName("editUser");

		return mav;
	}
	@RequestMapping("/editUserInfoByMyself")
	@ResponseBody
	public Map<String, String> editUserInfo(@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = new User();
		user.setEmail(email);
		user.setId(userId);
		user.setPhone(phone);
		user.setAddress(address);
		boolean flag = userService.editUserInfo(user);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
