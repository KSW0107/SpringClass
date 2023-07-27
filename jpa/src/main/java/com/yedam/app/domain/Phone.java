package com.yedam.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String phoneNumber;
	
	//기본 생성자
	public Phone(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}
	
//	@ManyToOne //phone / person 다대일 관계 형성
//	@JoinColumn(name = "person_id")
//	private Person person; 
}
