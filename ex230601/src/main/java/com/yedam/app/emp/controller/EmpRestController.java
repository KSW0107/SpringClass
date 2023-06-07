package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

//CRUD Rest 방식 사용하기

@RestController
public class EmpRestController {
	
	@Autowired
	EmpMapper empMapper;
	
	//전체조회 
	@GetMapping("emps")
	public List<EmpVO> getEmpList(){
		EmpVO empVO = new EmpVO();
		return empMapper.selectList(empVO);
	}
	
	//단건조회
	@GetMapping("emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
		// @PathVariable = 경로에서 {} 것은 데이터를 받아오겠다는 의미
		return empMapper.selectOne(employeeId);
	}
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empMapper.insertEmp(empVO);
		return empVO;
	}
	
	//수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId, @RequestBody EmpVO empVO) {
		//@RequestBody 사용 시 json으로 데이터를 보내야함
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}
		
	//삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if(result > 0) {
			success = true;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", success);
		map.put("employee_id", employeeId);
		
		return map;
	}
}
