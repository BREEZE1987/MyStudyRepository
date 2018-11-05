package com.helloworld.action;

import com.helloworld.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class HelloModelDrivenAction implements ModelDriven<User> {

	private User user; //= new User();
	
	//	两种初始化 User 的方式都可以
	@Override
	public User getModel() {
		return user = new User();
	}

	public String modelLogin() {
		System.out.println("----------ModelDrivenAction-----------");
		System.out.println(" userName = " + user.getUserName() 
						 + " password = " + user.getPassword());
		return Action.SUCCESS;
	}
}
