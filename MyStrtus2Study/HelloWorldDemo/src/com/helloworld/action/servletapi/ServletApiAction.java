package com.helloworld.action.servletapi;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.helloworld.model.User;

public class ServletApiAction {
	
	private User user;

	public String login() {
		if ("breeze".equals(user.getUserName()) && "1111".equals(user.getPassword())) {
			
			/*
			 * 解耦的方式获取 ServletAPI
			//	用户登录成功将用户信息写入 Session 中
			ActionContext.getContext().getSession().put("currentUser", user);
			
			//	获取 Application 对象
			ActionContext.getContext().getActionInvocation();
			
			//	获取 Request 对象
			Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
			request.put("password", user.getPassword());
			*/
			
			/*
			 * 耦合的方式获取 ServletAPI
			 */
			//	直接获取 Servlet 的 API，所以是耦合的方式
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("currentUser", user);
			
			return "success";
		}
		return "login";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
