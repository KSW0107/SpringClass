package com.yedam.app.emp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
@RequestMapping("/emp/") // 해당 컨트롤러의 모든 경로 앞에 붙음 (시큐리티 사용 시 유용)
public class EmpController {

	@Autowired
	EmpService empService;

	// sokcet
	private SimpMessagingTemplate template;

	@Autowired
	public EmpController(SimpMessagingTemplate template) {
		this.template = template;
		
	}
	//

	// 전체조회 페이지
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.getEmpList());
		//socket 
		String text = "[" + new Date() + "]:" + "사원목록조회";
		this.template.convertAndSend("/topic/alram", text); //@sendTo와 같은 역할
		//socket
		return "emp/empList";
	}

	// 단건조회 페이지
	@GetMapping({ "empInfo/{employeeId}", "empInfo" })
	public String empInfo(EmpVO empVO, Model model, @PathVariable(required = false) int employeeId) {
		if (employeeId != 0) {
			empVO.setEmployeeId(employeeId);
		}
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "emp/empInfo";
	}

	// 등록 페이지
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/empInsert";
	}

	// 등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}

	// 수정 페이지 폼
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, EmpVO vo) {
		model.addAttribute("empVO", empService.getEmpInfo(vo));
		return "emp/empUpdate";
	}

	//
}
