package com.xmh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xmh.entity.MainOrder;
import com.xmh.entity.SonOrder;
import com.xmh.entity.User;
import com.xmh.entity.UserAndOrders;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.OrderService;

@Controller
public class AdminOrdersManageController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/ordersManage")
	public ModelAndView ordersManage() {
		ModelAndView mav = new ModelAndView();
		List<MainOrder> mainOrders = orderService.getAllOrders();
		mav.addObject("orders",mainOrders);
		mav.setViewName("ordersManage");
		return mav;
	}
	@RequestMapping("/getSonOrdersbyoIdForAdmin")
	@ResponseBody
	public UserAndOrders getSonOrdersbyoIdForAdmin(@RequestParam("oid")Integer oid){
		//Map<String, String> map = new HashMap<String, String>();
		User user = orderService.getUserInfoByorders(oid);
		System.out.println(user);
		List<SonOrder> sonOrders = orderService.getSonOrdersbyoIdForAdmin(oid);
		if (sonOrders != null) {
			for (SonOrder sonOrder : sonOrders) {
				System.out.println(sonOrder);
			}
			UserAndOrders uao= new UserAndOrders();
			uao.setUser(user);
			uao.setOrders(sonOrders);
			System.out.println(uao);
			return uao;
		}

		return null;
	}
	@RequestMapping("/changeOrderState")
	@ResponseBody
	public Map<String, String> changeOrderState(@Param("oid")Integer oid,@Param("orderState")Integer orderState){
		Map<String, String> map = new HashMap<String, String>();
		boolean flag = orderService.changeOrderState(oid,orderState);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		return null;
	}
}
