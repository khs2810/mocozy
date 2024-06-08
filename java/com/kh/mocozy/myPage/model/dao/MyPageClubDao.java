package com.kh.mocozy.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.myPage.model.vo.MyPageClub;

@Repository
public class MyPageClubDao {
	
	public ArrayList<Club> selectClubList(SqlSessionTemplate sqlSession, int uno) {
		return (ArrayList)sqlSession.selectList("clubMapper.selectClubList", uno);
	}
	
	
}
 