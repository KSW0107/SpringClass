package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	public List<DeptVO> getAllDept();
	
	public DeptVO getDeptInfo(DeptVO deptVO);
	
	public int insertDeptInfo(DeptVO deptVO);
	
	public Map<String, Object> updateDeptList(List<DeptVO> deptVO);
	
	public int deleteDeptList(List<DeptVO> deptVO);
	
	public List<Map<String, String>> getManager();

	public List<Map<String, String>> getlocation();
}
