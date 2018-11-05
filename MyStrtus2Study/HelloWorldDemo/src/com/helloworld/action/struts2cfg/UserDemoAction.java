package com.helloworld.action.struts2cfg;

public class UserDemoAction {
	
	/**
	 * 添加
	 * @return
	 */
	public String save() {
		
		System.out.println("=======通配符方式调用======");
		
		return "success";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		
		return "success";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() {
		
		return "success";
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String find() {
		
		System.out.println("=======动态调用方法======");
		
		return "list";
	}

}
