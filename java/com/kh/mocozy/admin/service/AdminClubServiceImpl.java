package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminClubServiceImpl implements AdminClubService{
	
	@Autowired
	private AdminClubDao acDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Member> MemberList(int userNo) {
		ArrayList<Member> result = acDao.MemberList(sqlSession, userNo);
		return result;
	}
	
	@Override
	public int getClublist() {
		return acDao.getClublist(sqlSession);
	}
	
	//전체
	@Override
	public ArrayList<Club> selectClublist(PageInfo ci, String sortType) {
		return acDao.selectClublist(sqlSession, ci, sortType);
	}
	
	@Override
	public ArrayList<Club> getClubAllList() {
		return acDao.getClubAllList(sqlSession);
	}
	
	//진행중
	@Override
	public ArrayList<Club> selectClubProcess(PageInfo ci, String sortType) {
		return acDao.selectClubProcess(sqlSession, ci, sortType);
	}
	
	@Override
	public ArrayList<Club> getClubProcessList() {
		return acDao.getClubProcessList(sqlSession);
	}
	
	//숨김
	@Override
	public ArrayList<Club> selectClubHidden(PageInfo ci, String sortType) {
		return acDao.selectClubHidden(sqlSession, ci, sortType);
	}

	@Override
	public ArrayList<Club> getClubHiddenList() {
		return acDao.getClubHiddenList(sqlSession);
	}
	
	//종료됨
	@Override
	public ArrayList<Club> selectClubEnd(PageInfo ci, String sortType) {
		return acDao.selectClubEnd(sqlSession, ci, sortType);
	}
	
	@Override
	public ArrayList<Club> getClubEndList() {
		return acDao.getClubEndList(sqlSession);
	}
	
	//검색 개수
	@Override
	public int getClubSearchlist(HashMap<String, String> map) {
		return acDao.getClubSearchlist(sqlSession, map);
	}
	
	//전체 개수
	@Override
	public ArrayList<Club> selectSearchClublist(HashMap<String, String> map, PageInfo ci) {
		return acDao.selectSearchClublist(sqlSession, map, ci);
	}
	
	//진행중 검색
	@Override
	public ArrayList<Club> selectClubSearchProcess(HashMap<String, String> map, PageInfo ci) {
		return acDao.selectClubSearchProcess(sqlSession, map, ci);
	}
	
	//종료 검색
	@Override
	public ArrayList<Club> selectClubSearchEnd(HashMap<String, String> map, PageInfo ci) {
		return acDao.selectClubSearchEnd(sqlSession, map, ci);
	}

	//숨김 검색
	@Override
	public ArrayList<Club> selectClubSearchHidden(HashMap<String, String> map, PageInfo ci) {
		return acDao.selectClubSearchHidden(sqlSession, map, ci);
	}
	
	

}
