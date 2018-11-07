package com.breeze.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户信息
 * @author BREEZE
 * 为什么要序列化？
 * 为了将缓存数据取出执行反序列化操作，因为二级缓存数据存储介质多种多样，不一样在内存。
 *
 */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//	属性名和数据库表的字段名对应
	private int id;				//	用户 id
	private String name;		//	用户姓名
	private String sex;			//	用户性别
	private Date birthday;		//	用户生日
	private String address;		//	用户地址
	
	private List<Orders> orderList;	//	用户创建的订单列表
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Orders> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}	
}