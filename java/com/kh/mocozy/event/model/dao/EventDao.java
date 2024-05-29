package com.kh.mocozy.event.model.dao;

import java.util.ArrayList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;

@Repository
public class EventDao {
	    public ArrayList<Club> selecteventlist(SqlSessionTemplate sqlSession) {
	        return (ArrayList)sqlSession.selectList("eventMapper.selecteventlist");
	    }
	}
