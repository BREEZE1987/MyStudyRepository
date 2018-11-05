package com.helloworld.action.interceptor;

import com.helloworld.model.User;

public class TimerInterceptorAction {
	
	private User user;

	/**
	 * 
	 * @return
	 */
	public String login() {
		
		System.out.println("TimerInterceptorAction was called");
		
		return "success";
	}
	
	public String toSave() {
		
		System.out.println("dispatcher to save page!");
		
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
