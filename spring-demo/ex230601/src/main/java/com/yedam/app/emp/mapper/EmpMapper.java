package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectEmp(int empNo);
	public List<EmpVO> selectEmpList(EmpVO vo);
	public int insertEmp(EmpVO vo);
	public int deleteEmp(int empNo);
	public int updateEmp(EmpVO vo);
	public int selectCount(EmpVO vo);
	public List<Map<String, String>> selectJobs();
	public List<Map<String, String>> selectDepts();
}
