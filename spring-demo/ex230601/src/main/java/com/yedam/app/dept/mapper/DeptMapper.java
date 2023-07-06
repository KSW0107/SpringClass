package com.yedam.app.dept.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	public DeptVO selectDept(DeptVO vo);
	public List<DeptVO> selectDeptList();
	public int insertDept(DeptVO vo);
	public int deleteDept(int deptId);
	public int updateDept(DeptVO vo);
	public List<Map<String, String>> selectManager();
	public List<Map<String, String>> selectLocation();
}
