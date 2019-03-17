package com.manage.ssm.dao;

import java.util.List;

import com.manage.ssm.bean.Dept;

public interface DeptMapper {
    int insert(Dept record);

    int insertSelective(Dept record);
    
    int deleteByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    Dept selectByPrimaryKey(Integer deptId);
    
    List<Dept> getDepts();
}