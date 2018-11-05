package com.helloworld.action.validate;

import com.helloworld.model.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserValidateAction extends ActionSupport {
	
	private User user;

	/**
	 ** 先执行 validate 方法，该方法通过后执行 execute 方法
	 ** 默认该方法是通过的。 
	 ** 在 validate 方法中，添加了 FieldError 或者 ActionError 那么该方法将
	 ** 执行不能通过，并且返回的结果集为 INPUT
	 */
	@Override
	public void validate() {
		System.out.println("----- validate -----");
	}
	
	public void validateSave() {
		System.out.println("----- validateSave -----");
		if (user.getUserName().length() < 4 
				|| user.getUserName().length() > 10) {
			//	用户名不合法，添加错误信息
			this.addFieldError("user.userName", "用户名不合法！");
		}
	}
	
	public String save() {
		System.out.println("----- execute -----");
		System.out.println(user);
		return "success";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
