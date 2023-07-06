package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
	command
	Pojo : 상속 필요없음

*/


// 객체 생성해서 컨테이너에 빈 등록하고 
// 스프링 디스패처 서블릿에서 호출할 수 있도록 커맨드 타입으로 만들어줌
// @Component 상속받음
@Controller	
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("empList")
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);	
		model.addAttribute("empList",empMapper.selectEmpList(vo));
		return "emp/empList";
	}
	
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("depts",empMapper.selectDepts());
		return "emp/empInsert";
	}
	
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList";
	}
	
	@GetMapping("empDelete")
	public String empDelete(@RequestParam("empId") int empId) {
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
	
	@GetMapping("empUpdate")
	public String empUpdate(Model model,@RequestParam("empId") int empId) {
		model.addAttribute("emp",empMapper.selectEmp(empId));
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("depts",empMapper.selectDepts());
		return "emp/empUpdate";
	}
	
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList";
	}
}
