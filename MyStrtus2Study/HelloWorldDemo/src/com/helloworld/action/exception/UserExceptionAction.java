package com.helloworld.action.exception;

import com.helloworld.exception.UserException;
import com.helloworld.service.UserService;
import com.helloworld.service.impl.UserServiceImpl;

public class UserExceptionAction {
	
	private UserService userService = new UserServiceImpl();
	
	public String delete() throws UserException {
		userService.delete(0);
		return "success";
	}

}
