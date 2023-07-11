package com.yedam.app.user.mapper;

import java.util.List;

import com.yedam.app.security.UserVO;

public interface userMapper {
	
	public UserVO selectUser(String id);
	
	public List<String> selectRole(String id);
}
