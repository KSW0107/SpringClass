package com.yedam.app.spring;

import org.springframework.stereotype.Component;

@Component("lgtv")
public class LGTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링으로 LGTV 켬");
	}

}
