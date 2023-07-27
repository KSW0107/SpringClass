package com.yedam.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable //다른 엔티티의 타입으로 들어간다는 의미
public class Name {

	private String firstName;

	private String middleName;
	
	@Column(nullable = false) // not null
	private String lastName;

}