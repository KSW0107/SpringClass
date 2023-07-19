package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.board.Board;
import com.yedam.app.board.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void insert() {
		Board b1 = Board.builder()
						.writer("test")
						.title("title")
//						.ttl("title")
						.contents("content")
						.regdate(new Date())
						.build();
		boardRepository.save(b1); // 등록
		Board b2 = boardRepository.findById(b1.getBno()).get(); // 단건조회
		assertEquals(b1.getTitle(), b2.getTitle()); // 등록한 타이틀과 조회한 타이틀이 같은지 비교
//		assertEquals(b1.getTtl(), b2.getTtl());
	}
	
	//@Test
	public void list() {
		Iterable<Board> list = boardRepository.findAll();
		System.out.println(list);
	}
	
	//@Test
	public void like() {
		Iterable<Board> list = boardRepository.findByTitleLike("%ti%");
		System.out.println(list);
	}
	
	//@Test
	public void query() {
		Iterable<Board> list = boardRepository.findContents("co");
		System.out.println(list);
	}
}
