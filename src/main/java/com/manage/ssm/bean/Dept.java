package com.manage.ssm.bean;

public class Dept {
    private Integer deptId;

    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
    	//trim方法，去掉字符串首尾空格
        this.deptName = deptName == null ? null : deptName.trim();
    }
}