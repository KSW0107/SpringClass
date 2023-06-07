package com.yedam.app.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

@RestController // 해당 컨트롤러의 모든 메서드는 데이터만 반환 (페이지 반환 X)
public class UserRestController {
		
		@PostMapping("insertUser")
		//@ResponseBody // 데이터만 반환하는 메서드 (페이지 반환 X)
		public UserVO insertUser(UserVO userVO) {
			System.out.println("name : "+userVO.getName());
			System.out.println("age : "+userVO.getAge());
			return userVO;
		}
		
		@GetMapping("getHome")
		public String getHome() {
			return "home";
		}
}	
