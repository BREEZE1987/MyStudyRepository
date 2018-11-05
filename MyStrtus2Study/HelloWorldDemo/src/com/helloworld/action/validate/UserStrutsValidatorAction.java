package com.helloworld.action.validate;

import com.helloworld.model.User;
import com.opensymphony.xwork2.ActionSupport;


public class UserStrutsValidatorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public String login() {
		System.out.println("------ Login -------");
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
