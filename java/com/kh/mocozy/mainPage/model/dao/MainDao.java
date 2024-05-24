package com.kh.mocozy.mainPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.Attachment;

@Repository
public class MainDao {
	

	public ArrayList<Attachment> selectAttachList(SqlSessionTemplate sqlSession, int cno) {
		System.out.println(cno);
		return (ArrayList)sqlSession.selectList("mainMapper.selectAttachList", cno);
	}

	public ArrayList<Club> selectSocial(SqlSessionTemplate sqlSession, int cno) {
		return (ArrayList)sqlSession.selectList("mypageMapper.selectRestList", cno);
	}
	
}
