package com.xmh.mapper;

import java.util.List;

import com.xmh.entity.MainOrder;
import com.xmh.entity.SonOrder;
import com.xmh.entity.User;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
	boolean createMainOrder(MainOrder mainOrder);
	boolean createSonOrder(@Param("sonOrders") List<SonOrder> sonOrders);
	List<MainOrder> getAllOrdersByUserId(@Param("userId") Integer userId);
	List<SonOrder> getSonOrderByOid(@Param("oId") Integer oid);
	boolean orders_handle(@Param("oid") Integer oid, @Param("orderState") Integer orderState);
	List<MainOrder> getAllOrders();
	User getUserInfoByorders(@Param("oid") Integer oid);
	boolean changeOrderState(@Param("oid") Integer oid, @Param("orderState") Integer orderState);
	MainOrder getMainOrderByOid(@Param("oid") Integer oid);
}
