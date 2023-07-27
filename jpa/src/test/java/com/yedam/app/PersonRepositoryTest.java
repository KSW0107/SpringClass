package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.domain.Person;
import com.yedam.app.domain.PersonRepository;
import com.yedam.app.domain.Phone;

@SpringBootTest
public class PersonRepositoryTest {
	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void 회원단건조회() {
		Person person = personRepository.findById(4L).get();
		System.out.println(person);
	}
	
	//@Test
	//@Transactional // 실행 후 자동 rollback
	public void 회원등록() {
		Person person = new Person();
		person.setName("홍길동");
		person.getPhones().add(new Phone("111-22222"));
		person.getPhones().add(new Phone("222-33333"));
		
		//person 저장
		personRepository.save(person);
		Person p = personRepository.findById(1L).get();
		
		//phones 개수 비교
		assertEquals(p.getPhones().size(), 2);
	}
}
