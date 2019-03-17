package com.manage.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.ssm.bean.Emp;
import com.manage.ssm.bean.Msg;
import com.manage.ssm.service.EmpService;


/**
 * 处理CRUD
 * @author bruce
 *
 */
@Controller
public class EmpController {
	
	@Resource
	private EmpService empService;

	/**
	 * 删除员工信息
	 * 
	 * @param empId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("empId") Integer empId) {
		empService.deleteEmp(empId);
		return Msg.success();
	}

	/**
	 * 配置上HttpPutFormContentFilter，将请求体中的数据解析包装成一个map。
	 * 修改员工数据
	 * @param emp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
	public Msg updateEmp(Emp emp) {
		empService.updateEmp(emp);
		return Msg.success();
	}

	/**
	 * 根据id查询员工
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("empId") Integer empId) {
		Emp emp = empService.getEmpById(empId);
		return Msg.success().add("emp", emp);
	}

	/**
	 * 员工保存 
	 * 1、支持JSR303校验 
	 * 2、导入Hibernate-Validator
	 * 
	 * @return
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Emp emp, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败，应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名：" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			empService.saveEmp(emp);
			return Msg.success();
		}

	}

	/**
	 * 导入jackson包。
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		//分页仅使startPage方法后的第一条查询有效
		PageHelper.startPage(pn, 5);
		List<Emp> emps = empService.getAll();
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Emp> page = new PageInfo<Emp>(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 测试pagehelper
	 * @param model
	 * @return
	 */
	@RequestMapping("/empss")
	public String getEmps(Model model) {
		PageHelper.startPage(1, 5);
		List<Emp> emps = empService.getAll();
		PageInfo<Emp> page = new PageInfo<Emp>(emps, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}

}
