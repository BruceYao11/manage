package com.manage.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manage.ssm.bean.Msg;
import com.manage.ssm.bean.User;
import com.manage.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Msg login(User user) {
		User result = userService.findUser(user.getUserId());
		if(result == null || (user.getPassword() != result.getPassword())){
			return Msg.fail();
		}
		return Msg.success();
	}
    
	/*
	 * 用户注册
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public Msg addUser(User user){
		User result = userService.findUser(user.getUserId());
		if(result != null){
			return Msg.fail();
		}
		userService.addUser(user);
		return Msg.success();
	}
	
	public void add(ModelAndView modelAndView){
		
	}
}
