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

	// 경로 : <-> 기능 ( View )
	// 경로 + Method -> Unique

	// 조회 ( 데이터, 페이지 ) -> GET
	// 등록, 수정, 삭제 -> POST

	// 전체조회
	@GetMapping("deptList") // @RequestParam 필수값 => (required = false)로 필수값 해제 (있어도 ok 없어도 ok)
	public String getDeptAllList(@RequestParam(required = false) String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getAllDept());

		System.out.println("redirect : " + msg);

		// ? = object request에서 flashMap 들고오기
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
	 * redirect vs forward
	 * 
	 * 클라이언트 입장에서 return "redirect: 경로" - 데이터,경로 반환 -> 총 2번 요청 (첫번째 요청,응답 데이터는 조회
	 * 불가) => model.addAttribure 계속 사용 불가 (요청,응답이 깨짐) -> redirectAttribue 사용
	 * 
	 * forward - 요청 내에서 경로 이동 후 반환 -> 총 1번 요청 (첫번째 요청,응답 데이터는 조회 가능) =>
	 * model.addAttribure 계속 사용 (요청,응답이 유지되기때문)
	 */

	// 등록 - 기능 : POST
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) {
		deptService.insertDeptInfo(deptVO);

		// 보안 필요시 addFlashAttribute 사용 (session에 복사 후 redirect 시 가져옴)
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId());

		// 파라미터 방식(?no=1&..)으로 전송됨
		rtt.addAttribute("msg", "test");

		// 아래 파라미터 방식(?no=1&..)으로 데이터 전송됨
		// return "redirect:deptList?departmentId="+deptVO.getDepartmentId();
		return "redirect:deptList";
	}

	// 수정 - 기능 : POST

	// @PostMapping("deptUpdate")
	@ResponseBody // 응답의 body에 필요한 데이터를 집어넣어줌 / 경로 말고 데이터만 이동
	/*
	 * @RequestBody request는 헤더, 바디로 이루어짐 => 그 중에 바디 부분만 가져옴 : JSON 포맷을 사용하는 경우 사용
	 * -> content-type : 'application/json' 사용해야함
	 */
	public Map<String, Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO) {
		return deptService.updateDeptList(deptVO);
	}
	/*
	 * public String deptUpdate(@RequestBody List<DeptInfoVO> deptVO,
	 * RedirectAttributes rtt) { Map<String, Object> map =
	 * deptService.updateDeptList(deptVO); rtt.addFlashAttribute("updateRes", map);
	 * return "redirect:deptInfo?departmentId="+deptVO.get(0).getDepartmentId(); }
	 */

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
