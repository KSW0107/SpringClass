package com.yedam.app;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
public class JacksonTest {
	
	@Test
	public void toObject() throws JsonMappingException, JsonProcessingException {
		String str = "{\"employeeId\":100,\"firstName\":\"길동\",\"lastName\":\"홍\",\"hireDate\":\"2023-07-07\",\"departmentId\":0}";
		ObjectMapper ob = new ObjectMapper();
		EmpVO vo = ob.readValue(str, EmpVO.class);
		System.out.println(vo);
	}
	
	//@Test
	public void toJson() throws JsonProcessingException {
		EmpVO vo = EmpVO.builder().firstName("길동").lastName("홍").employeeId(100).hireDate(new Date()).build();
		ObjectMapper ob = new ObjectMapper();
		String str = ob.writeValueAsString(vo);
		System.out.println(str);
	}
}
