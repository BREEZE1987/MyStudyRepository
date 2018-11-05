package com.helloworld.service.impl;

import com.helloworld.exception.UserException;
import com.helloworld.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void delete(int id) throws UserException {
		if (id == 0) {
			throw new UserException("删除的数据不存");
		}
	}

}
