package com.manage.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.ssm.bean.Dept;
import com.manage.ssm.bean.Msg;
import com.manage.ssm.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息
		List<Dept> list = deptService.getDepts();
		return Msg.success().add("depts", list);
	}
}
