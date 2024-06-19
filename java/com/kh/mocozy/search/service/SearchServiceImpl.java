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
	public int searchForm(HashMap<String, String> map) {
		return sDao.searchForm(sqlSession, map);
	}

	@Override
	public ArrayList<Club> searchFormAjax(HashMap<String, String> map, PageInfo re) {
		return sDao.searchFormAjax(sqlSession, map, re);
	}

	@Override
	public ArrayList<Member> MemberList(int clubNo) {
		ArrayList<Member> result = sDao.MemberList(sqlSession, clubNo);
		return result;
	}
}
