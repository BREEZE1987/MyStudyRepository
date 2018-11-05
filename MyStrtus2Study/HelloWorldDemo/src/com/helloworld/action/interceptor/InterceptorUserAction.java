package com.helloworld.action.interceptor;

import com.helloworld.model.User;
import com.opensymphony.xwork2.ActionContext;

public class InterceptorUserAction {
	
	private User user;

	
	public String login() {
		if ("breeze".equals(user.getUserName()) && 
				"1111".equals(user.getPassword())) {
			ActionContext.getContext().getSession().put("currentUser", user);
			return "success";
		}
		return "login";
	}
	
	public String hello() {
		
		System.out.println("Say hello to the success page!");
		
		return "success";
	}
	
	public String toSave() {
		
		System.out.println("user interceptor dispatcher to save page!");
		
		return "success";
	}
	
	public String save() {
		
		System.out.println("add user to database!");
		
		return "success";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
