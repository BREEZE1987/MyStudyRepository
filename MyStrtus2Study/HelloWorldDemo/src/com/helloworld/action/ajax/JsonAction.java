package com.helloworld.action.ajax;

import java.util.ArrayList;
import java.util.List;

import com.helloworld.model.User;

public class JsonAction {
	
	private List<User> userList;

	
	public String list() {
		userList = new ArrayList<User>();
		userList.add(new User("张三", "123456"));
		userList.add(new User("李四", "123456"));
		userList.add(new User("王五", "123456"));
		
		return "success";
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
