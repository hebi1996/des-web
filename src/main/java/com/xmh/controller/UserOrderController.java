package com.xmh.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmh.entity.Cart;
import com.xmh.entity.MainOrder;
import com.xmh.entity.SonOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xmh.service.CartService;
import com.xmh.service.OrderService;

@Controller
public class UserOrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@RequestMapping("/createMyOrders")
	@ResponseBody
	public Map<String, String> addOrders(HttpServletRequest request){
		Map< String, String> map = new HashMap<String, String>();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		//����û����ﳵ��Ϣ
		List<Cart> carts = cartService.getAllCartsByUser(userId);

		//���ϵͳ��ǰʱ��
		long timeString = System.currentTimeMillis();
		Timestamp time = new Timestamp(timeString);

		//�ܼ�
		double orderPrice = 0;
		//�Ӷ���
		
		SonOrder sonOrder = null;
		List<SonOrder> sonOrders = new ArrayList<SonOrder>();
		for (Cart c : carts) {
			sonOrder = new SonOrder();
			System.out.println(c);
			double count = c.getCount();
			double mealPrice = c.getFoodInfo().getMealPrice();
			orderPrice+=count*mealPrice;
			sonOrder.setMealId(c.getMealId());
			sonOrder.setMealPrice(c.getFoodInfo().getMealPrice());
			sonOrder.setMealCount(c.getCount());
			sonOrders.add(sonOrder);
		}
		
		System.out.println(orderPrice);
		MainOrder mainOrder = new MainOrder();
		mainOrder.setUserId(userId);
		mainOrder.setOrderPrice(orderPrice);
		mainOrder.setOrderTime(time);
		mainOrder.setSonOrders(sonOrders);
		
		
		boolean flag = orderService.createMyOrders(mainOrder);
		
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;
	}
	@RequestMapping("/myOrders")
	public ModelAndView getAllOrdersByUserId(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		List<MainOrder> mainOrders= orderService.getAllOrdersByUserId(userId);
		mav.addObject("orders", mainOrders);
		mav.setViewName("myOrders");
		
		return mav;
	}
	@RequestMapping("/getSonOrderByOid")
	@ResponseBody
	public List<SonOrder> getSonOrderByOid(@RequestParam("oid")Integer oid){
		//Map< String, Object> map = new HashMap<String, Object>();
		
		List<SonOrder> sonOrders = orderService.getSonOrderByOid(oid);
		if (sonOrders !=null) {
			//map.put("sonOrders",sonOrders);
			return sonOrders;
		}
		
		return null;
	}
	@RequestMapping("/orders_handle")
	@ResponseBody
	public Map<String, String> orders_handle(@RequestParam("oid")Integer oid,@RequestParam("orderState")Integer orderState){
		Map< String, String> map = new HashMap<String, String>();
		boolean flag = orderService.orders_handle(oid,orderState);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;
	}
	@RequestMapping("/orders_cancel")
	@ResponseBody
	public Map<String, String> orders_cancel(@RequestParam("oid")Integer oid,@RequestParam("orderState")Integer orderState){
		Map< String, String> map = new HashMap<String, String>();
		boolean flag = orderService.orders_cancel(oid,orderState);
		if (flag) {
			map.put("result", "success");
			return map;
		}
		
		return null;
	}
	
}
