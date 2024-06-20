package com.kh.mocozy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.admin.model.dao.AdminChatDao;
import com.kh.mocozy.admin.model.dao.AdminClubDao;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class AdminChatServiceImpl implements AdminChatService{
	
	@Autowired
	private AdminChatDao achDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//chat status변경
	@Override
	public int chatStatus(HashMap<String, Object> map){
		return achDao.chatStatus(sqlSession, map);
	}
}
