package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> getBookAllList();
	public int getBookNo();
	public int insertBookInfo(BookVO bookVO);
	public List<RentVO> getBookRentList();
}
