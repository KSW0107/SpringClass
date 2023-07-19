package com.yedam.app.board;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
	// CrudRepository<도메인, 타입>을 적어주면 된다
	
	List<Board> findByTitleLike(String title);
	
	@Query("select b from Board b where contents like %?1")
	List<Board> findContents(String content);
	
}
