package com.breeze.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.breeze.mybatis.mapper.UsersMapper;
import com.breeze.mybatis.pojo.User;
import com.breeze.mybatis.pojo.UserCustom;
import com.breeze.mybatis.pojo.UserQueryVo;

public class UserMapperTest {
	
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
	public void testFindUserById() throws Exception {
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 UserMapper 对象，MyBatis 自动生成 mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		//	调用 userMapper 方法
		User user = userMapper.findUserById(1);
		
		sqlSession.close();
		
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 UserMapper 对象，MyBatis 自动生成 mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		//	调用 userMapper 方法
		User user = userMapper.findUserByIdResultMap(1);
		
		sqlSession.close();
		
		System.out.println(user);
	}
	
	@Test
	public void testFindUsersByName() throws Exception {
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 UserMapper 对象，MyBatis 自动生成 mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		//	调用 userMapper 方法
		List<User> userList = userMapper.findUsersByName("小明");
		//User user = userMapper.findUsersByName("小明");
		
		sqlSession.close();
		
		System.out.println(userList);
	}
	
	@Test
	public void testFindUserList() throws Exception {
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 UserMapper 对象，MyBatis 自动生成 mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		//	创建包装类型对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		
		//	由于这里使用了动态 sql，如果不设置某个值，条件不会拼接在 sql 中
		//userCustom.setSex("1");
		//userCustom.setName("小明");
		
		//	传入多个 id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(10);
		ids.add(27);
		ids.add(28);
		userQueryVo.setIds(ids);
		
		userQueryVo.setUserCustom(userCustom);
		
		//	调用 userMapper 方法
		List<UserCustom> userList = userMapper.findUserList(userQueryVo);
		
		sqlSession.close();
		
		System.out.println(userList);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	创建 UserMapper 对象，MyBatis 自动生成 mapper 代理对象
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		//	创建包装类型对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setName("小明");
		userQueryVo.setUserCustom(userCustom);
		
		//	调用 userMapper 方法
		int userCount = userMapper.findUserCount(userQueryVo);
		
		sqlSession.close();
		
		System.out.println(userCount);
	}
	
}