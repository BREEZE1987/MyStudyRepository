package com.breeze.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.breeze.mybatis.pojo.User;

public class MybatisFirst {
	
	//	根据 id 查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {
		
		//	Mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		
		//	得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//	创建会话工厂，传入 MyBatis 配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//	通过 SqlSession 操作数据库
		//	第一个参数：映射文件中 statement 的 id，等于 namespace + "." + statement 的 id
		//	第二个参数：指定和映射文件中所匹配的 parameterType 类型的参数
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(user);
		
		//	释放资源
		sqlSession.close();
	}
	
	//	根据用户名称模糊查询用户列表
	@Test
	public void findUsersByNameTest() throws IOException {
		
			//	Mybatis 配置文件
			String resource = "SqlMapConfig.xml";
			
			//	得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//	创建会话工厂，传入 MyBatis 配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//	通过工厂得到 SqlSession 
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//	userList 中的 User 和映射文件中 resultType 所指定的类型一致
			List<User> userList = sqlSession.selectList("test.findUsersByName", "小明");
			
			System.out.println(userList);
			
			//	释放资源
			sqlSession.close();
	}
	
	//	添加用户信息
	@Test
	public void insertUserTest() throws IOException {
				
				//	Mybatis 配置文件
				String resource = "SqlMapConfig.xml";
				
				//	得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);
				
				//	创建会话工厂，传入 MyBatis 配置文件信息
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
				//	通过工厂得到 SqlSession 
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				//	插入用户对象
				User user = new User();
				user.setName("王小军");
				user.setBirthday(new Date());
				user.setSex("1");
				user.setAddress("湖南株洲");
				
				sqlSession.insert("test.insertUser", user);
				
				//	提效事务
				sqlSession.commit();
				
				System.out.println(user.getId());
				
				//	释放资源
				sqlSession.close();
	}
	
	//	根据用户 id 删除用户信息
	@Test
	public void deleteUserByIdTest() throws IOException {
				
				//	Mybatis 配置文件
				String resource = "SqlMapConfig.xml";
				
				//	得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);
				
				//	创建会话工厂，传入 MyBatis 配置文件信息
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
				//	通过工厂得到 SqlSession 
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				sqlSession.delete("deleteUserById", 26);
				
				//	提效事务
				sqlSession.commit();
				
				//	释放资源
				sqlSession.close();
	}
	
	//	根据用户 id 更新用户信息
	@Test
	public void updateUserByIdTest() throws IOException {
				
				//	Mybatis 配置文件
				String resource = "SqlMapConfig.xml";
				
				//	得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);
				
				//	创建会话工厂，传入 MyBatis 配置文件信息
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
				//	通过工厂得到 SqlSession 
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				//	插入用户对象
				User user = new User();
				user.setId(27);
				user.setName("王大军");
				user.setBirthday(new Date());
				user.setSex("2");
				user.setAddress("湖南株洲");
				
				sqlSession.update("test.updateUserById", user);
				
				//	提效事务
				sqlSession.commit();
				
				//	释放资源
				sqlSession.close();
	}

}
