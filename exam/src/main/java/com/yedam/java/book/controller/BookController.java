package com.yedam.java.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	//전체조회 페이지
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.getBookAllList();
		model.addAttribute("bookList",list);
		return "book/bookList";
	}
	
	//등록 페이지
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		int bookNo = bookService.getBookNo();
		model.addAttribute("bookNo", bookNo);
		return "book/bookInsert";
	}
	
	//등록 처리
	@PostMapping("bookInsert")
	public String bookInsert(BookVO bookVO){
		bookService.insertBookInfo(bookVO);
		return "redirect:bookList";
	}
	
	//대여현황 페이지
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<RentVO> list = bookService.getBookRentList();
		model.addAttribute("rentList",list);
		return "book/rentList";
	}
}
