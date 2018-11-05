package com.helloworld.ognldemo;

import java.util.HashMap;
import java.util.Map;

import com.helloworld.model.User;

import ognl.Ognl;

public class OgnlDemo {
	
	public static void main(String[] args) throws Exception {
		/**
		 * ognl 思想，把数据分为两类，常用的和不常用的
		 */
		
		//	不常用的数据存放在容器比较大的地方
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school", "my house");
		map.put("address", "Zhuzhou,Hunan,China");
		
		//	常用的数据
		User user = new User();
		user.setUserName("张三丰");
		user.setPassword("123456");
		
		//	ognl 的表达式的写法，常用的数据直接获取，不常用的数据加 # 获取
		String result = (String)Ognl.getValue("#address", map, user);
		System.out.println(result);
	}

}
