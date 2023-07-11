package com.yedam.app.user.service;

import java.util.List;

import com.yedam.app.security.UserVO;

public interface UserService {
	public UserVO selectUser(UserVO vo);
	
	public List<String> selectRole(String id);
}
