package com.breeze.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.breeze.mybatis.mapper.OrdersMapperCustom;
import com.breeze.mybatis.mapper.UsersMapper;
import com.breeze.mybatis.pojo.Orders;
import com.breeze.mybatis.pojo.OrdersCustom;
import com.breeze.mybatis.pojo.User;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		
		String resource = "SqlMapConfig.xml";	//	Mybatis 配置文件
		
		//	得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//	创建会话工厂，传入 MyBatis 配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindOrderUser() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//	调用 OrderMapperCustom 方法
		List<OrdersCustom> orderCustomList = ordersMapperCustom.findOrderUser();
		
		System.out.println(orderCustomList);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//	调用 OrderMapperCustom 方法
		List<Orders> orderList = ordersMapperCustom.findOrdersUserResultMap();
		
		System.out.println(orderList);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//	调用 OrderMapperCustom 方法
		List<Orders> orderList = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		
		System.out.println(orderList);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//	调用 OrderMapperCustom 方法
		List<User> userList = ordersMapperCustom.findUserAndItemsResultMap();
		
		System.out.println(userList);
		
		sqlSession.close();
	}
	
	/**
	 * 查询订单关联查询用户，用户信息使用延迟加载
	 * @throws Exception
	 */
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//	调用 OrderMapperCustom 方法，查询订单信息（单表）
		List<Orders> orderList = ordersMapperCustom.findOrdersUserLazyLoading();
		
		//	遍历上边的订单列表
		for (Orders orders : orderList) {
			//	执行 getUser() 去查询用户信息，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user);
		}
		
		sqlSession.close();
	}
	
	/**
	 * 测试一级缓存
	 * @throws Exception
	 */
	@Test
	public void testCache1() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
	
		//	下边查询使用同一个 SqlSession 
		//	第一次发起请求，查询 id 为 1 的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		//	如果 SqlSession 去执行 commit 操作（执行插入、更新、删除），
		//	清除 SqlSession 中的一级缓存，这样做的目的是为了让缓存中存储的是最新信息，避免脏读。
		//user1.setName("王五22");
		//userMapper.updateUserById(user1);
		
		//	执行 commit 操作去清空缓存
		//sqlSession.commit();
		
		//	第二次发起请求，查询 id 为 1 的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	/**
	 * 测试二级缓存
	 * @throws Exception
	 */
	@Test
	public void testCache2() throws Exception {
	
		//	通过会话工厂得到 SqlSession
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		
		//SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		//	创建 Mapper 代理对象
		UsersMapper userMapper1 = sqlSession1.getMapper(UsersMapper.class);
	
		//	下边查询使用同一个 SqlSession 
		//	第一次发起请求，查询 id 为 1 的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		
		sqlSession1.close();
		
		//	使用 sqlSession3 执行 commit() 操作
//		UsersMapper userMapper3 = sqlSession3.getMapper(UsersMapper.class);
//		User user3 = userMapper3.findUserById(1);
//		user3.setName("王五");
//		userMapper3.updateUserById(user3);
//		
//		sqlSession3.commit();
//		sqlSession3.close();
		
		
		
		UsersMapper userMapper2 = sqlSession2.getMapper(UsersMapper.class);
		//	第二次发起请求，查询 id 为 1 的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		
		sqlSession2.close();
	}
}