package com.xmh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmh.service.UserService;

@Controller
public class UserLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/userlogin")
	public String userLogin() {
		return "userlogin";
	}

	@RequestMapping(value = "/tomain",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> toMain(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,HttpServletRequest request){
		System.out.println(username);
		System.out.println(password);
		
		
		Map<String,String> map = new HashMap<String, String>();
		User user=userService.selectUserByUNAndPWD(username,password);

		if (user !=null) {
			request.getSession().setAttribute("userId", user.getId());
			request.getSession().setAttribute("loginName", username);
			request.getSession().setAttribute("loginPwd", password);
			map.put("result", username);
			return map;
		}
		return null;
	}
	@RequestMapping("/userMain")
	public String main(HttpServletRequest request){
		System.out.println(request.getSession().getAttribute("loginName"));
		System.out.println(request.getSession().getAttribute("loginPwd"));
		return "main";
	}
	@RequestMapping("/userRegister")
	public String userRegister() {
		return "userRegister";
	}
	@RequestMapping("/userFace")
	public String userFace() {
		return "userFace";
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, String> userRegister(@RequestParam(value = "loginName")String loginName,@RequestParam(value = "loginPwd")String loginPwd ,@RequestParam(value = "trueName")String trueName ,@RequestParam(value = "email")String email ,@RequestParam(value = "phone")String phone,@RequestParam(value = "address")String address) {
		Map<String, String> map= new HashMap<String, String>();
		User user = new User();
		user.setLoginName(loginName);
		user.setLoginPwd(loginPwd);
		user.setTrueName(trueName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		user.setIntegral(100);
		boolean flag = userService.addUser(user);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
	@RequestMapping("/userloginout")
	@ResponseBody
	public Map<String, String> userloginout(HttpServletRequest request){
		Map<String, String> map= new HashMap<String, String>();
		request.getSession().invalidate();
		map.put("result", "success");
		return map;
		
	}
}
