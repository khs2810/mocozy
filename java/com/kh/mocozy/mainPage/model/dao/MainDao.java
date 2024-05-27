package com.kh.mocozy.mainPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.Attachment;
import com.kh.mocozy.member.model.vo.Member;

@Repository
public class MainDao {
	

	public ArrayList<Club> selectSocial(SqlSessionTemplate sqlSession, int cno) {
		System.out.println(cno);
		return (ArrayList)sqlSession.selectList("mainMapper.selectSocial", cno);
	}

	public Member selectClubMem(SqlSessionTemplate sqlSession, int uno) {
		return sqlSession.selectOne("MainMapper.selectClubMem", uno);
	}
	
}
