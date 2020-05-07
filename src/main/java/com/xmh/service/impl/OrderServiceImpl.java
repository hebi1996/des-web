package com.xmh.service.impl;


import java.util.List;

import com.xmh.entity.MainOrder;
import com.xmh.entity.SonOrder;
import com.xmh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xmh.mapper.OrderMapper;
import com.xmh.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
	public boolean createMyOrders(MainOrder mainOrder) {
		boolean flag=false;
		boolean main = orderMapper.createMainOrder(mainOrder);
		if (main) {
			List<SonOrder> sonOrders = mainOrder.getSonOrders();
			System.out.println(sonOrders);
			for (SonOrder s : sonOrders) {
				s.setoId(mainOrder.getOid());
			}
			boolean son =  orderMapper.createSonOrder(sonOrders);
			if (son) {
				flag = true;
			}
		}

		
		return flag;
	}

	@Override
	public List<MainOrder> getAllOrdersByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderMapper.getAllOrdersByUserId(userId);
	}

	@Override
	public List<SonOrder> getSonOrderByOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderMapper.getSonOrderByOid(oid);
	}

	@Override
	public boolean orders_handle(Integer oid, Integer orderState) {
		// TODO Auto-generated method stub
		return orderMapper.orders_handle(oid,orderState);
	}

	@Override
	public boolean orders_cancel(Integer oid, Integer orderState) {
		// TODO Auto-generated method stub
		return orderMapper.orders_handle(oid,orderState);
	}

	@Override
	public List<MainOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return orderMapper.getAllOrders();
	}

	@Override
	public List<SonOrder> getSonOrdersbyoIdForAdmin(Integer oid) {
		// TODO Auto-generated method stub
		return orderMapper.getSonOrderByOid(oid);
	}

	@Override
	public User getUserInfoByorders(Integer oid) {
		// TODO Auto-generated method stub
		return orderMapper.getUserInfoByorders(oid);
	}

	@Override
	public boolean changeOrderState(Integer oid, Integer orderState) {
		// TODO Auto-generated method stub
		return orderMapper.changeOrderState(oid,orderState);
	}

}
