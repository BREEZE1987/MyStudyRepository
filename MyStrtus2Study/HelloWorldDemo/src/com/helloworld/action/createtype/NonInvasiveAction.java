package com.helloworld.action.createtype;

/**
 * 无侵入性的实现 Action 处理类
 * @author BREEZE
 *
 */
public class NonInvasiveAction {
	
	public String execute() {
		
		System.out.println("无侵入性的实现 Action 处理类！");
		
		return "success";
	}
	
}
