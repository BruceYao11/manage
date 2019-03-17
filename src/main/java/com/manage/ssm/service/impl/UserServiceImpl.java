package com.manage.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.ssm.bean.User;
import com.manage.ssm.dao.UserMapper;
import com.manage.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(Integer userId) {
		return userMapper.findUserById(userId);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

}
