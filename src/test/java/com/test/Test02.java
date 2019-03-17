package com.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manage.ssm.bean.Emp;
import com.manage.ssm.dao.EmpMapper;

/**
 * 测试dao层的工作 
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Test02 {
	
		@Autowired
		EmpMapper empMapper;

		@Autowired
		SqlSession sqlSession;

		@Test
		public void testCRUD() {
			// 1、生成员工数据，测试员工插入--写有参无参构造方法
			empMapper.insertSelective(new Emp(3, "Jerry", "M", "Jerry977@163.com", 1));

			// 2、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。使用uuid

			EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
			// 生成一千条测试数据
			for (int i = 0; i < 1000; i++) {
				String uid = UUID.randomUUID().toString().substring(0, 5) + i;
				mapper.insertSelective(new Emp(4, uid, "M", uid + "@163.com", 2));
			}
			System.out.println("批量完成");

		}

}
