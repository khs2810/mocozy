package com.kh.mocozy.search.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.search.model.dao.SearchDao;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDao sDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/* searchListCount() */
	@Override
	public int searchCount() {
		return sDao.searchCount(sqlSession);
	}
	
	/* selectSearchList */
	@Override
	public ArrayList<Club> selectSearchList(HashMap<String, String> map, PageInfo re) {
		return sDao.selectSearchList(sqlSession, map, re);
	}
	
	// 순수 검색
	@Override
	public int searchForm(HashMap<String, String> map){
		return sDao.searchForm(sqlSession, map);
	}
	
	// 카테고리 검색
	/* MenuSelectSearchRest */
	@Override
	public ArrayList<Club> selectSearchCate(PageInfo re) {
		return sDao.selectSearchCate(sqlSession, re);
	}
	
	// 클럽 검색
	/* selectSearchRest */
	@Override
	public ArrayList<Club> selectSearchClub(PageInfo re) {
		return sDao.selectSearchClub(sqlSession, re);
	}
}
