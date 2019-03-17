package com.manage.ssm.service;

import java.util.List;

import com.manage.ssm.bean.Emp;

public interface EmpService {
	//根据id查询员工
    public Emp getEmpById(Integer empId);

    //添加一条数据,保存员工
    public void saveEmp(Emp emp);

    //查询所有员工数据
	public List<Emp> getAll();
	
	//更新员工
	public void updateEmp(Emp emp);
	
	//删除员工
	public void deleteEmp(Integer EmpId);
}
