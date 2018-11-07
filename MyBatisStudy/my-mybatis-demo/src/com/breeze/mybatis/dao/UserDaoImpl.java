package com.breeze.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.breeze.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	//	需要向 dao 实现类中注入 SqlSessionFactory
	//	通过构造方法注入
	
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById", id);
		
		sqlSession.close();	//	释放资源
		
		return user;
	}
	
	@Override
	public List<User> findUsersByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> userList = sqlSession.selectList("test.findUsersByName", name);
		
		sqlSession.close();	//	释放资源
		
		return userList;
	}

	@Override
	public void insertUser(User user) throws Exception {
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();	//	提效事务
		
		sqlSession.close();	//	释放资源
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		//	通过工厂得到 SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUserById", 26);
		
		sqlSession.commit();	//	提效事务
		
		sqlSession.close();		//	释放资源

	}
}
