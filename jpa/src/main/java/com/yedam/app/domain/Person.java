package com.yedam.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue // DB에 맞게 auto 생성
	private Long id;
	
	private String name;
	
	//fetch = 조회 순서
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Phone> phones = new ArrayList<>(); 
}
