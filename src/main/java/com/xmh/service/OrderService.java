package com.xmh.service;


import com.xmh.entity.MainOrder;
import com.xmh.entity.SonOrder;
import com.xmh.entity.User;

import java.util.List;
import java.util.Map;

public interface OrderService {
	boolean createMyOrders(MainOrder mainOrder);
	List<MainOrder> getAllOrdersByUserId(Integer userId);
	List<SonOrder> getSonOrderByOid(Integer oid);
	boolean orders_handle(Integer oid, Integer orderState);
	Map<String,String> orders_cancel(Integer oid, Integer orderState);
	List<MainOrder> getAllOrders();
	List<SonOrder> getSonOrdersbyoIdForAdmin(Integer oid);
	User getUserInfoByorders(Integer oid);
	boolean changeOrderState(Integer oid, Integer orderState);

}
