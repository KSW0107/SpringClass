package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Ignore
	public void getEmpinfo() {
		EmpVO findEmp = empMapper.selectEmp(100);
		assertEquals(findEmp.getFirstName(), "Steven");
	}
	
	
	@Ignore
	public void getEmpList() {
		EmpVO vo = new EmpVO();
//		vo.setFirstName("e");
		vo.setDepartmentId("50,60");
		vo.setOrderColumn("department_id,first_name");
		List<EmpVO> empList = empMapper.selectEmpList(vo);
		int cnt = empMapper.selectCount(vo);
		System.out.println(empList);
		//assertEquals(empList.get(0).getEmployeeId(), "100");
	}
	
	@Ignore
	public void insertEmp() {
		EmpVO vo = new EmpVO();
		vo.setLastName("shin");
		vo.setEmail("test@test");
		vo.setHireDate("20230602");
		vo.setJobId("IT_PROG");
		
		int test = empMapper.insertEmp(vo);
		System.out.println(vo);
		assertEquals(test>0, true);
	}
	
	@Ignore
	public void deleteEmp() {
		int test = empMapper.deleteEmp(221);
		assertEquals(test>0, true);
	}
	
	@Ignore
	public void updateEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("221");
		vo.setLastName("Jaeyeong");
		
		int test = empMapper.updateEmp(vo);
		assertEquals(test>0, true);
	}
	
	@Ignore
	public void selectJobs() {
		List<Map<String, String>> list = empMapper.selectJobs();
		System.out.println(list);
	}
	@Test
	public void selectDepts() {
		List<Map<String, String>> list = empMapper.selectDepts();
		System.out.println(list);
	}
}
