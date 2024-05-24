package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.template.vo.Attachment;
import com.kh.mocozy.mainPage.model.dao.MainDao;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDao mainDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Club> selectSocial(int clubno) {
		ArrayList<Club> list = mainDao.selectSocial(sqlSession, clubno);

		for(int i=0; i<list.size(); i++) {
			ArrayList<Attachment> attachmentList = mainDao.selectAttachList(sqlSession, list.get(i).getClubNo());
			list.get(i).setClubAtList(attachmentList);
		}

		sqlSession.close();
		return list;
}
}