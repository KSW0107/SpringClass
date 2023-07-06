package com.yedam.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex230613ApplicationTests {
	@Autowired
	StringEncryptor jasyptStringEncryptor;
	
	
	@Test
	void propertiesEncrypt() {
		//암호화 대상
		String[] strArray = {"oracle.jdbc.OracleDriver",
							"jdbc:oracle:thin:@127.0.0.1:1521/xe",
							"hr",
							"hr"};
		
		//암호화
		for(String str : strArray) {
							//암호화 함수
			String enyStr = jasyptStringEncryptor.encrypt(str);
			System.out.println(enyStr);
		}
	}

}
