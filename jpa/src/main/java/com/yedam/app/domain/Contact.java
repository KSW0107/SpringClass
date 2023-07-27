package com.yedam.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //시퀀스 생성
	private Integer id;

	private Name name;
	
	@Column(length = 2000) // 칼럼 정보 수정
	private String notes;

	private boolean starred;

}
