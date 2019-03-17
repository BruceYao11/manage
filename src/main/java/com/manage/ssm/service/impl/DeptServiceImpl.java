package com.manage.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.ssm.bean.Dept;
import com.manage.ssm.dao.DeptMapper;
import com.manage.ssm.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> getDepts() {
		List<Dept> list = deptMapper.getDepts();
		return list;
	}

}
