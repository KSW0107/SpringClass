package com.yedam.app.dept.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> getAllDept() {
		return deptMapper.selectDeptList();
	}

	@Override
	public DeptVO getDeptInfo(DeptVO deptVO) {		
		return deptMapper.selectDept(deptVO);
	}

	@Override
	public int insertDeptInfo(DeptVO deptVO) {
		int result =deptMapper.insertDept(deptVO);
		System.out.println("id : "+deptVO.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DeptVO> deptVO) {
		boolean result = false;
		List<Integer> successList = new ArrayList<>();
		
		int count=0;
		for(DeptVO deptInfo : deptVO) {
			int res = deptMapper.updateDept(deptInfo);
			if(res>0) {
				// 정상적으로 수정이 되었을 경우
				count++;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		
		if(count>0) {
			result=true;
		}
		
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);
		
		return map;
	}

	@Override
	public int deleteDeptList(List<DeptVO> deptVO) {
		int count=0;
		for(DeptVO deptInfo : deptVO) {
			count+=deptMapper.deleteDept(deptInfo.getDepartmentId());
		}
		return count;
	}

	@Override
	public List<Map<String, String>> getManager() {
		return deptMapper.selectManager();
	}

	@Override
	public List<Map<String, String>> getlocation() {
		return deptMapper.selectLocation();
	}
	
}
