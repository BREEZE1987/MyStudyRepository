package com.helloworld.action;

import com.helloworld.model.MessageStore;

/**
 * struts2 的第一个案例
 * @author BREEZE
 *
 */
public class HelloAction {
	
	private MessageStore messageStore;
	
	/**
	 * 	在 struts2 中所有的业务方法都是 public
	 * 	返回值为 String 类型，所有的业务方法都没有参数
	 * 	方法名可以自定义，默认为 execute 
	 * @return
	 */
	public String execute() {
		System.out.println("Hello Struts2!");
		return "success";
	}
	
	public String hello() {
		messageStore = new MessageStore();
		return "success";
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

//	public void setMessageStore(MessageStore messageStore) {
//		this.messageStore = messageStore;
//	}
}