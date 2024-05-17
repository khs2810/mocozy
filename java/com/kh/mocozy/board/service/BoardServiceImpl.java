package com.kh.mocozy.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
}
