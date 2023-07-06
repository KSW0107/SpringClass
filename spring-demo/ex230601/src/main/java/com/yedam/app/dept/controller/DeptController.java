package com.yedam.app.dept.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	 
	@Autowired
	DeptService deptService;
	
	// 경로 <-> 기능 (View)
	// 경로 + Method -> Unique
	
	// 조회 (데이터, 페이지) -> GET
	// 등록,수정,삭제 -> POST
	
	// 전체 조회 - 페이지
	@RequestMapping(value="deptList" , method=RequestMethod.GET)
	public String deptList(Model model,@ModelAttribute("dept") DeptVO vo) {
		model.addAttribute("deptList", deptService.getAllDept());
		return "dept/deptList";
	}
	
	// 단건 조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptVO deptVO,Model model) {
		DeptVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo",findDept);	
		return "dept/deptInfo";
	}
		
	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsetFrom(Model model) {
		model.addAttribute("managers", deptService.getManager());
		model.addAttribute("locations", deptService.getlocation());
		return "dept/deptInsert";
	}
	
	// 등록 - 기능
	@PostMapping("deptInsert")
	public String deptInsert(DeptVO vo) {
		deptService.insertDeptInfo(vo);
		return "redirect:deptList";
	}
	
	// 삭제 - 기능
	@GetMapping("deptDelete")
	public String deptDelete(@RequestParam("deptId") int deptId) {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(deptId);
		List<DeptVO> list = new ArrayList<>();
		list.add(vo);
		deptService.deleteDeptList(list);
		return "redirect:deptList";
	}
	
	// 수정 - 페이지
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Model model,@RequestParam("deptId") DeptVO vo) {
		model.addAttribute("dept", deptService.getDeptInfo(vo));
		model.addAttribute("managers", deptService.getManager());
		model.addAttribute("locations", deptService.getlocation());
		return "dept/deptUpdate";
	}
	
	// 수정 - 기능
	@PostMapping("deptUpdate")
	public String deptUpdate(DeptVO vo) {
		deptService.updateDeptList(null);
		return "redirect:deptList";
	}
}
