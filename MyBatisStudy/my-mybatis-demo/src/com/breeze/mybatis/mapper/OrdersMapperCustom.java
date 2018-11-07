package com.breeze.mybatis.mapper;

import java.util.List;

import com.breeze.mybatis.pojo.Orders;
import com.breeze.mybatis.pojo.OrdersCustom;
import com.breeze.mybatis.pojo.User;

public interface OrdersMapperCustom {
	
	/**
	 * 查询订单关联查询用户信息
	 * @return
	 * @throws Exception
	 */
	public List<OrdersCustom> findOrderUser() throws Exception;
	
	/**
	 * 查询订单关联查询用户使用 resultMap
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	/**
	 * 查询订单（关联用户）及订单明细
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	
	/**
	 * 查询用户购买的商品信息
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	
	/**
	 * 查询订单关联查询用户，用户信息是延迟加载
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;

}
