package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> getBookAllList() {
		return bookMapper.selectAllBook();
	}

	@Override
	public int getBookNo() {
		return bookMapper.getBookNo();
	}

	@Override
	public int insertBookInfo(BookVO bookVO) {
		return bookMapper.insertBookInfo(bookVO);
	}

	@Override
	public List<RentVO> getBookRentList() {
		return bookMapper.selectBookRent();
	}

}
