package com.kh.mocozy.search.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.search.model.dao.SearchDao;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDao sDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int searchCount() {
		return sDao.searchCount(sqlSession);
	}
	
	@Override
	public ArrayList<Club> selectSearchList(HashMap<String, String> map, PageInfo re) {
		return sDao.selectSearchList(sqlSession, map, re);
	}
	
	//검색
	@Override
	public int searchForm(HashMap<String, String> map){
		return sDao.searchForm(sqlSession, map);
	}
	
	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = sDao.MemberList(sqlSession, clubNo);
		return result;
	}
	
	@Override
	public ArrayList<Club> getSocialing(PageInfo pi) {
	     return sDao.getSocialing(sqlSession, pi);
	}

	@Override
	public ArrayList<Club> getChallenge(PageInfo pi) {
	     return sDao.getChallenge(sqlSession, pi);
	}

	@Override
	public int getReviewCount(int clubNo) {
		return sDao.getReviewCount(sqlSession, clubNo);
	}
	    
	@Override
	public int getPickedCount(int clubNo) {
		return sDao.getPickedCount(sqlSession, clubNo);
	}
}
