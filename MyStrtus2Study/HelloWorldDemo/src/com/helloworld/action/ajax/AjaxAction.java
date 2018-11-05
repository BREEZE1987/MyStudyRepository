package com.helloworld.action.ajax;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.helloworld.model.User;

public class AjaxAction {
	
	private User user;
	
	public String checkName() throws IOException {
		
		
		System.out.println("-----checkName-----");
		System.out.println("-----" + user.getUserName() + "-----");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		if ("breeze".equals(user.getUserName())) {
			response.getWriter().print("true");
		} else {
			response.getWriter().print("false");
		}
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
