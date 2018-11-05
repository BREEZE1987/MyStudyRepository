package com.helloworld.action;

import com.helloworld.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Struts2 数据处理案例
 * @author BREEZE
 *
 */
public class LoginAction {
	
	/*
	 	1、使用 Struts2 获取表单数据：只需表单域名称和 Action 处理类的属性名称一致，并且
	 	提供属性的 set 方法，那么在 Action 处理类中即可获得表单数据。这种获取数据的方式
	 	称为属性驱动。
	 	
	 	2、如果数据需显示到页面上，那么该数据可以做做为处理类的属性，处理方法后该属性有值，
	 	并且有该属性的 get 方法。那么在页面上可以直接通 el 表达式获取。
	 	
	 	3、在 Struts2 中，对于表单数据的处理有 3 种方式：属性驱动，对象驱动，模型驱动。
	 	
	 	4、对象驱动
	 		在 Action 的处理类中，属性以对象方式存在，该属性对象只需声明即可，需要保证
	 		该属性对象有无参构造方法，并且提供 get/set 方法， 在表单域中的表单域名称
	 		属性对象名.属性对象的属性来命名。
	 		
	 	5、模型驱动
	 		在对象驱动中，页面的表单域名称比较的复杂，如果对象属性比较多的情况下，代码量
	 		比较大，通过模型驱动可以解决这个问题。
	 		模型驱动需要实现 ModelDriven 接口，并且主动将对象创建好。
	 */
	
	private String userName;
	
	private String password;
	
	//private String pYear;
	
	//	保证对象要有无参构造方法
	private User user;

	/**
	 * 登录的处理业务
	 * @return
	 */
	public String login() {
		System.out.println("userName= " + userName + ", password= " + password);
		//System.out.println("pYear= " + pYear);
		
//		System.out.println("userName= " + user.getUserName() 
//				+ ", password= " + user.getPassword());
		
		ActionContext.getContext().getApplication().put("address","My House");
		
		return Action.SUCCESS;
	}
	
	public String getUserName() {
		//System.out.println("getUserName------------get");
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public String getpYear() {
//		return pYear;
//	}
//
//	public void setpYear(String pYear) {
//		this.pYear = pYear;
//	}
	
}
