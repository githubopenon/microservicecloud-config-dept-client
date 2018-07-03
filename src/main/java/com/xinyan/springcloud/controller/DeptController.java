package com.xinyan.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xinyan.springcloud.entities.Dept;
import com.xinyan.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	/**
	 * 部门列表
	 * @return
	 */
	@GetMapping("/dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}
	
	/**
	 * 查找某一个部门
	 * @param id
	 * @return
	 */
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		return deptService.findDept(id);
	}

	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	@PostMapping("/dept/add")
//	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public Boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
}
