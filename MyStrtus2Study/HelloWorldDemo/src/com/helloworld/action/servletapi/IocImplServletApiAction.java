package com.helloworld.action.servletapi;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.helloworld.model.User;

public class IocImplServletApiAction implements ServletRequestAware {
	
	private User user;
	
	private HttpServletRequest request;

	public String ioclogin() {
		if ("breeze".equals(user.getUserName()) 
				&& "1111".equals(user.getPassword())) {
			
			System.out.println("======= implements ServletRequestAware ========");
		
			request.getSession().setAttribute("currentUser", user);
			
			return "success";
		}
		return "login";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
