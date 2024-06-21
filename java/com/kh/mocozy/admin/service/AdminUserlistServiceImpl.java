package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.admin.model.dao.AdminUserlistDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminUserlistServiceImpl implements AdminUserlistService{
	
	@Autowired
	private AdminUserlistDao auDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getMemberlist() {
		return auDao.getMemberlist(sqlSession);
	}
	
	//insertAdmin
	@Override
	public ArrayList<Member> insertManagerList(PageInfo mi, String sortType) {
		return auDao.insertManagerList(sqlSession, mi, sortType);
	}
	
	//전체
	@Override
	public ArrayList<Member> MemberAll(PageInfo mi, String sortType) {
		return auDao.MemberAll(sqlSession, mi, sortType);
	}

	@Override
	public ArrayList<Member> MemberAllList() {
		return auDao.MemberAllList(sqlSession);
	}
	
	//진행중
	@Override
	public ArrayList<Member> MemberActive(PageInfo mi, String sortType) {
		return auDao.MemberActive(sqlSession, mi, sortType);
	}

	@Override
	public ArrayList<Member> MemberActiveList() {
		return auDao.MemberActiveList(sqlSession);
	}
	
	//종료
	@Override
	public ArrayList<Member> MemberEnd(PageInfo mi, String sortType) {
		return auDao.MemberEnd(sqlSession, mi, sortType);
	}

	@Override
	public ArrayList<Member> MemberEndList() {
		return auDao.MemberEndList(sqlSession);
	}
	
	//숨김
	@Override
	public ArrayList<Member> MemberHidden(PageInfo mi, String sortType) {
		return auDao.MemberHidden(sqlSession, mi, sortType);
	}
	
	@Override
	public ArrayList<Member> MemberHiddenList() {
		return auDao.MemberHiddenList(sqlSession);
	}
	
	//검색 리스트
	@Override
	public int getMemberSearchlist(HashMap<String, String> map) {
		return auDao.getMemberSearchlist(sqlSession, map);
	}
	
	//전체 검색
	@Override
	public ArrayList<Member> MemberSearchAll(HashMap<String, String> map, PageInfo mi) {
		return auDao.MemberSearchAll(sqlSession, map, mi);
	}
	
	//진행중 검색
	@Override
	public ArrayList<Member> MemberSearchActive(HashMap<String, String> map, PageInfo mi) {
		return auDao.MemberSearchActive(sqlSession, map, mi);
	}
	
	//종료된 검색
	@Override
	public ArrayList<Member> MemberSearchEnd(HashMap<String, String> map, PageInfo mi) {
		return auDao.MemberSearchEnd(sqlSession, map, mi);
	}

	//insertManager 검색
	@Override
	public ArrayList<Member> insertManagerSearchList(HashMap<String, String> map, PageInfo mi) {
		return auDao.insertManagerSearchList(sqlSession, map, mi);
	}

	//숨김 검색
	@Override
	public ArrayList<Member> MemberSearchHidden(HashMap<String, String> map, PageInfo mi) {
		return auDao.MemberSearchHidden(sqlSession, map, mi);
	}
	
	//숨김 처리
	@Override
	public int userChangeStatus(HashMap<String, Object> map) {
		return auDao.userChangeStatus(sqlSession, map);
	}
	
	//권한 부여
	@Override
	public int ManagerstatusAjax(HashMap<String, Object> map) {
		return auDao.ManagerstatusAjax(sqlSession, map);
	}
	
}

