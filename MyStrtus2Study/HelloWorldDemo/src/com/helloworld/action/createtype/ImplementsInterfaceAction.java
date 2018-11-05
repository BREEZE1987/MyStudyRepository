package com.helloworld.action.createtype;

import com.opensymphony.xwork2.Action;

/**
 * 通过实现 Action 接口来创建处理类
 * 1、实现 Action 接口的方式，可以直接使用 Action 提供的常量
 * 2、必须重写默认处理方法
 * 这种方式使用的比较少
 * @author BREEZE
 *
 */
public class ImplementsInterfaceAction implements Action {

	@Override
	public String execute() throws Exception {
		
		System.out.println("action 的处理类被执行了……");
		
		return SUCCESS;
	}

}
