package com.kh.mocozy.event.model.dao;

import java.util.ArrayList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;

@Repository
public class CateDao {
	    public ArrayList<Club> selectcatelist(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("cateMapper.selectcatelist");
	    }
	}
