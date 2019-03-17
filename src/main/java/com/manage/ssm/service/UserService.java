package com.manage.ssm.service;

import com.manage.ssm.bean.User;

public interface UserService {
	public User findUser(Integer userId);
		
	public void addUser(User user);
}
