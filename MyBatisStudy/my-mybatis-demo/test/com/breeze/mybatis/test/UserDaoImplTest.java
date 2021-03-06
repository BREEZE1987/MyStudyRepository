package com.breeze.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.breeze.mybatis.dao.UserDao;
import com.breeze.mybatis.dao.UserDaoImpl;
import com.breeze.mybatis.pojo.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		//	创建 sqlSessionFactory
		
		//	MyBatis 配置文件
		String resource = "SqlMapConfig.xml";
		
		//	得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//	创建会话工厂，传入 MyBatis 的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		//	创建 UserDao 的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		//	调用 UserDao 的方法
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}

}
