package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	//전체조회
	public List<BookVO> selectAllBook();
	//단건조회
	public int getBookNo();
	//등록
	public int insertBookInfo(BookVO bookVO); 
	//대여현황
	 public List<RentVO> selectBookRent();
}
