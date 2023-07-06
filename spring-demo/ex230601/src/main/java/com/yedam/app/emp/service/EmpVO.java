package com.yedam.app.emp.service;

import java.util.Map;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	String hireDate;
	String jobId;
	String departmentId;
	String orderColumn;
	String[] getDeptArr() {
		return departmentId.split(",");
	}
}
