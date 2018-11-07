package com.breeze.mybatis.pojo;

import java.util.List;

/**
 * 包装类型
 * @author BREEZE
 *
 */
public class UserQueryVo {
	
	//	传入多个 id
	private List<Integer> ids;
	
	//	在这里包装所需的查询条件
	
	//	用户查询条件
	private UserCustom userCustom;
	
	//	可以包装其它的查询条件，订单，商品

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
}