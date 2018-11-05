package com.helloworld.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器的实现
 * @author BREEZE
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 判断是否是登录的 action，如果是断续执行
	 * 如果不是，判断 session 中是否有用户存
	 * 如果没有，跳转到登录页面
	 * 如果有，继续执行
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("---------- 自定义的登录拦截器被执行！ ----------");
		
		String actionName = invocation.getProxy().getActionName();
		if ("interceptorUserLogin".equals(actionName)) {
			return invocation.invoke();
		}
		
		Object currentUser = invocation.getInvocationContext().getSession().get("currentUser");
		if (currentUser != null) {
			return invocation.invoke();
		}
		return "login";
	}

	

}
