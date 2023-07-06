package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	int departmentId;
	String departmentName;
	int managerId;
	int locationId;
}
