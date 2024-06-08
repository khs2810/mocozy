package com.kh.mocozy.myPage.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.myPage.model.vo.MyPageClub;

@Repository
public class MyPageClubDao {
//	마이페이지 최근 모임 목록
	public List<MyPageClub> myPageClub(SqlSessionTemplate sqlSession, MyPageClub myPageClub) {
		return sqlSession.selectList("myPageClubMapper.myPageClub", myPageClub);
	}
	
//	마이페이지  최근 찜 목록
	public List<MyPageClub> myPageClubPicked(SqlSessionTemplate sqlSession, MyPageClub myPageClub) {
		return sqlSession.selectList("myPageClubMapper.myPageClubPicked", myPageClub);
	}
	
}
