package com.breeze.mybatis.dao;

import java.util.List;

import com.breeze.mybatis.pojo.User;

public interface UserDao {
	
	/**
	 * 根据 id 查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(int id) throws Exception;
	
	/**
	 * 根据用户名称查询用户信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUsersByName(String name) throws Exception;

	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 根据 id 删除用户信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(int id) throws Exception;
}
