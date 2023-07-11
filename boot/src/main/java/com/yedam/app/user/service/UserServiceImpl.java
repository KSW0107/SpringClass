package com.yedam.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.UserVO;
import com.yedam.app.user.mapper.userMapper;

//사용자 지정 UserDetailsService
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Autowired
	userMapper userMapper;

	@Override
	public UserVO selectUser(UserVO vo) {
		return userMapper.selectUser(vo.getLoginId());
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.selectUser(username);
		
		//user 조회가 안 되는 경우
		if(vo==null) {
			throw new UsernameNotFoundException("no user");
		}
		
		vo.setRoleName(userMapper.selectRole(vo.getId()));
		return vo;
	}

	@Override
	public List<String> selectRole(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
