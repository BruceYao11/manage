package com.manage.ssm.dao;

import com.manage.ssm.bean.User;

public interface UserMapper {

	User findUserById(Integer userId);
	
	void addUser(User user);
}
