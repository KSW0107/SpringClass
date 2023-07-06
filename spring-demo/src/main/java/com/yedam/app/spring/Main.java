package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//경로에는 공백 X
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		TV tv = (TV)ctx.getBean("lgtv");
		tv.on();

	}
}
