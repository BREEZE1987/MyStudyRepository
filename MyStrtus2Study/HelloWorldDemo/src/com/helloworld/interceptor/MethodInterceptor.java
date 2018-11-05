package com.helloworld.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 方法拦截器实现
 * @author BREEZE
 *
 */
public class MethodInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("---------- 方法拦截器被执行了！----------");
		
		return invocation.invoke();
	}

}
