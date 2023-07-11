package com.yedam.app.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

//사용자 정의 UserVO
@Data
public class UserVO implements UserDetails {
	private String id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	List<String> roleName;
	

	@Override //Collection -> 권한
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//String으로 받아온 Role을 GrantedAuthority로 타입변환 루 Collection에 담는 과정
		
		//Collection 생성
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		//String 변환
		for(String role : roleName) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return roles;
	}

	@Override
	public String getUsername() {
		return loginId;
	}

	@Override
	public boolean isAccountNonExpired() { //휴면 계정, 패스워드 변경 처리
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //5회 비번 입력 오류 시 실행
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//로그인 권한
	@Override
	public boolean isEnabled() {
		return true;
	}
}
