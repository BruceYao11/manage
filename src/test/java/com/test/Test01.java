package com.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.manage.ssm.bean.Emp;
import com.manage.ssm.service.EmpService;

//@ContextConfiguration指定Spring配置文件的位置
@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
/**
 * 测试spring整合mybatis spring方式
 * 
 */
public class Test01 {
    private static Logger logger = Logger.getLogger(Test01.class);

    @Autowired
    private EmpService empService = null;

    /**
     * 测试查询
     */
    @Test
    public void test1() {
        Emp emp = empService.getEmpById(1);
        logger.info("值：" + emp.getEmpName());
        logger.info(JSON.toJSONString(emp));
    }
    /**
     * 测试添加
     */
    @Test
    public void test2() {       
        Emp emp = new Emp();
        emp.setEmpId(9);
        emp.setEmpName("小明");
        emp.setGender("M");
        emp.setEmail("123456@163.com");
        emp.setDeptId(1);
//        int count = empService.insert(emp);
//        logger.info("count：" +count);
    }
}