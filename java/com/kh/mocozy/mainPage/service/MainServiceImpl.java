package com.kh.mocozy.mainPage.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.mainPage.model.dao.MainDao;
import com.kh.mocozy.member.model.vo.Member;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDao mainDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
    @Override
    public ArrayList<Club> selectSocial(int cno) {
        return mainDao.selectSocial(sqlSession, cno);
    }

    @Override
    public Member selectClubMem(int uno) {
        return mainDao.selectClubMem(sqlSession, uno);
    }
}