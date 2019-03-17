package com.manage.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.ssm.bean.Emp;
import com.manage.ssm.dao.EmpMapper;
import com.manage.ssm.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
    private EmpMapper empMapper;

    public Emp getEmpById(Integer empId) {   
		return empMapper.selectByPrimaryKey(empId);
    }

	@Override
	public List<Emp> getAll() {
		return empMapper.getEmps();
	}

	@Override
	public void saveEmp(Emp emp) {
		empMapper.insertSelective(emp);
	}

	@Override
	public void updateEmp(Emp emp) {
		empMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void deleteEmp(Integer EmpId) {
		empMapper.deleteByPrimaryKey(EmpId);
	}
	
}
