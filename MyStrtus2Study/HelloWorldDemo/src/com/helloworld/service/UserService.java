package com.helloworld.service;

import com.helloworld.exception.UserException;

public interface UserService {
	
	public void delete(int id) throws UserException;

}
