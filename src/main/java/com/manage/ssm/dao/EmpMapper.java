package com.manage.ssm.dao;

import java.util.List;

import com.manage.ssm.bean.Emp;

public interface EmpMapper {
    int insert(Emp record);

    int insertSelective(Emp record);
    
    int deleteByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    
    Emp selectByPrimaryKey(Integer empId);

	List<Emp> getEmps();
}