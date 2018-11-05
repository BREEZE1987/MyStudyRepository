package com.helloworld.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器有两种实现方式：
 *	a)、实现 Interceptor 接口
 *	b)、继承 AbstractInterceptor 类
 * @author BREEZE
 *
 */
public class MyInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**
	 * 拦截器的主体实现
	 * 当拦截器方法被调用执行后，需要通过 invocation.invoke 调用下一个拦截器
	 * 如果没有拦截器那么执行 action 中的业务方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("--------- 自定义拦截器被执行了！ ----------");
				
		return invocation.invoke();	//	返回结果集
	}

}
