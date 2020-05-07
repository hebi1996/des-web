package com.xmh.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmh.service.UserService;

@Controller
public class AdminLoginController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "adminlogin";
	}
	

	@RequestMapping(value = "/toadmain",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> toAdmain(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,HttpServletRequest request){
		System.out.println(username);
		System.out.println(password);
		
		Map<String,String> map = new HashMap<String, String>();
		Admin admin=userService.selectAdminByUNAndPWD(username,password);
		if (admin !=null) {
			request.getSession().setAttribute("userId", admin.getId());
			request.getSession().setAttribute("loginName", username);
			request.getSession().setAttribute("loginPwd", password);
			map.put("result" , username);
			return map;
		}
		return null;	
	}
	@RequestMapping("/adminMain")
	public String main(){
		return "main";
	}
	@RequestMapping("/adminFace")
	public String adminFace() {
		return "adminFace";
	}
	
	@RequestMapping("/adminloginout")
	@ResponseBody
	public Map<String, String> userloginout(HttpServletRequest request){
		Map<String, String> map= new HashMap<String, String>();
		request.getSession().invalidate();
		map.put("result", "success");
		return map;
		
	}
		
	
	
}
