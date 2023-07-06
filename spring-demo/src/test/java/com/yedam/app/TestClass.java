package com.yedam.app;

import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

//클래스 지정
@RunWith(SpringJUnit4ClassRunner.class)
//경로 지정
@ContextConfiguration("classpath:applicationContext.xml")

public class TestClass {
	
	//불러오기
	@Autowired
	Restaurant res;
	
	//테스트하기
	@Test
	public void creatBeanTest() {
		res.open();
	}
	
	//Ignore => 테스트에서 제외
	@Ignore
	public void test() {
		System.out.println("간단한 테스트");
		// 초록색 -> 참 , 빨간색 -> 거짓
		//해당값이 null인지를 boolean으로 반환
		assertNull(null);
	}
}
