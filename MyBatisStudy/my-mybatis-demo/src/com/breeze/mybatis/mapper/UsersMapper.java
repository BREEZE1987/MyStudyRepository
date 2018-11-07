package com.breeze.mybatis.mapper;

import java.util.List;

import com.breeze.mybatis.pojo.User;
import com.breeze.mybatis.pojo.UserCustom;
import com.breeze.mybatis.pojo.UserQueryVo;

/**
 * mapper 接口相当于 dao 接口
 * 
 * mapper 代理的开发规范
 * 1、在 mapper.xml 中 namespace 等于 mapper 接口地址
 * 
 * 2、mapper.java 接口中的方法名和 mapper.xml 中的 statement 的 id 一致
 * 
 * 3、mapper.java 接口中的方法输入参数类型和 mapper.xml 中 statement 的 parameterType 指定的类型一致
 * 
 * 4、mapper.java 接口中的方法返回值类型和 mapper.xml 中 statement 的 resultType 指定的类型一致
 * 
 * @author BREEZE
 *
 */
public interface UsersMapper {
	
	/**
	 * 根据 id 查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(int id) throws Exception;
	
	/**
	 * 根据 id 查询用户信息，使用 resultMap 输出
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserByIdResultMap(int id) throws Exception;
	
	/**
	 * 根据用户名称查询用户信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUsersByName(String name) throws Exception;
	
	/**
	 * 用户信息的综合查询
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 用户信息的综合查询总数
	 * @param userQueryVo
	 * @return
	 * @throws Exception
	 */
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

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
	
	/**
	 * 更新用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUserById(User user) throws Exception;
	
	/**
	 * 代理对象内部调用 selectOne 或 selectList
	 * 
	 * 1、如果 mapper 方法返回单个 pojo 对象（非集合对象），代理对象内部通过 selectOne 查询数据库
	 * 
	 * 2、如果 mapper 方法返回集合对象，代理对象内部通过 selectList 查询数据库。
	 */
	
	
	/**
	 * mapper 接口方法参数只能有一个，是否影响系统开发？
	 * 
	 * mapper 接口方法参数只能有一个，是否不利于扩展维护？
	 * 
	 * 系统框架中，dao 层的代码是被业务层公用的。
	 * 即使 mapper 接口只有一个参数，可以使用包装类型的 pojo 满足不同业务方法的需求
	 * 
	 * 注意：持久层方法的参数可以使用包装类型、map……，service 方法中建义不要使用包装类型（不利于业务层的维护及扩展性的）。
	 */

}
