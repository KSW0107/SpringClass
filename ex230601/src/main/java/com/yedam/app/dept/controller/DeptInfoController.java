package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;

@Controller("deptInfo")
public class DeptInfoController {
	@Autowired
	DeptService deptService;
	
	// 조회 ( 데이터, 페이지 ) -> GET 방식
	// 등록, 수정, 삭제 -> POST 방식
	
	//model -> 스프링이 관리하는 request & response

	// 전체조회
	@GetMapping("deptList") // @RequestParam => 파라미터 가져오는 방식 / (required = false)로 필수값 해제
	public String getDeptAllList(@RequestParam(required = false) String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getAllDept());

		System.out.println("redirect : " + msg);

		// ? = object             request에서 flashMap 들고오기
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId"));
		}

		return "dept/list";
	}

	// 단건조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptInfoVO deptVO, Model model) {
		DeptInfoVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo", findDept);
		return "dept/info";
	}

	// 등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		return "dept/insert";
	}

	/*
	  redirect vs forward
	  
	  redirect - 데이터,경로 반환 -> 응답 후 redirect 경로로 재요청 => 
	  model.addAttribure 계속 사용 불가 -> redirectAttribue 사용
	 
	  forward - 요청 내에서 경로 이동 후 반환 -> 총 1번 요청 (첫번째 요청,응답 데이터는 조회 가능) =>
	  model.addAttribure 계속 사용
	  
	*/

	// 등록 - 기능 : POST
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) {
		deptService.insertDeptInfo(deptVO);
		//RedirectAttributes -> session에 복사 후 redirect 시 가져옴
		
		//addFlashAttribute -> POST 방식
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId());

		// addAttribute -> GET 방식
		rtt.addAttribute("msg", "test");

		return "redirect:deptList";
	}

	// 수정 - 기능 : POST
	
	//@RequestBody , @ResponseBody -> 비동기 통신시 body을 자바객체로, 자바객체를 body으로 자동변환 (json타입 사용)
	
	 //@RequestBody request => 바디 부분만 가져옴 -> content-type : 'application/json' 사용해야함
	 //여러가지 데이터를 전송해야할 때 유용
	 
	// @PostMapping("deptUpdate")
	@ResponseBody // 경로 말고 body에 담겨있는 데이터만 이동 (페이지 이동 X)
	public Map<String, Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO) {
		return deptService.updateDeptList(deptVO);
	}

	@PostMapping("deptUpdate")
	@ResponseBody
	public String deptUpdateText(@RequestBody List<DeptInfoVO> deptVO) {
		Map<String, Object> map = deptService.updateDeptList(deptVO);
		return "success";
	}

	// 삭제 - 기능 : POST
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result = deptService.deletDeptList(list.getDeptList());
		return "redirect:deptList?msg=" + result;
	}

}
