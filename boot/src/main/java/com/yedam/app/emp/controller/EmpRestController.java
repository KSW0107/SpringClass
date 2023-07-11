package com.yedam.app.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("employees")
	public List<EmpVO> empList() {
		return empService.getEmpList();
	}
	
	@GetMapping("employees/{employeeId}")
	public EmpVO empList(@PathVariable int employeeId, EmpVO vo) {
		vo.setEmployeeId(employeeId);
		return empService.getEmpInfo(vo);
	}
	
	//등록 메서드 방식으로 동작 메서드 결정
	@PostMapping("employees")
	public EmpVO empInsert(EmpVO vo) {
		empService.insertEmpInfo(vo);
		return vo;
	}
	
	@PutMapping("employees")
	public EmpVO empUpdate(@RequestBody EmpVO vo) {
		System.out.println(vo);
		return vo;
	}
	
	@DeleteMapping("employees/{id}")
	public String empDelete(@PathVariable(name = "id") String empId) {
		System.out.println(empId);
		return empId;
	}
}
