package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("aService")
public class AaaServiceImpl implements AaaService {
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional // 메서드 내부의 SQL문들은 같은 트랜잭션을 사용하게 함 -> 하나라도 실패했을 시 전체 롤백됨 
				   //( @Transactional 사용 X 시 성공한 것은 반영됨)
	@Override
	public void insert() {
		aaaMapper.insert("201");
		aaaMapper.insert("a01");
	}

}
