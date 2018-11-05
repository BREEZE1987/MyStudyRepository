package com.helloworld.action.struts2cfg;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage(value="struts-default")
@Namespace(value="/annotation")
public class UserAnnotationAction {
	
	/**
	 * 添加
	 * @return
	 */
	@Action(value="save", results={
		@Result(name="success", type="redirect", location="/annotation/find")
	})
	public String save() {
		
		System.out.println("=======注解的配置方式 save ======");
		
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
	@Action(value="find", results= {
		@Result(name="success", type="redirect", location="/annotation/find"),
		@Result(name="list", location="/index.jsp")
	})
	public String find() {
		
		System.out.println("=======注解的配配方式 find ======");
		
		return "list";
	}

}
