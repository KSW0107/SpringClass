package com.yedam.app.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bno;
	private String title;
//	private String ttl;
	private String contents;
//	@On
	private String writer;
	private Date regdate;
	private Date updatedate;
	private String image;
}
