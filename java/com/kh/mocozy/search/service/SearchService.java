package com.kh.mocozy.search.service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface SearchService {

	ArrayList<Club> selectSearchList(HashMap<String, String> map, PageInfo re);
	
	ArrayList<Club> selectSearchView(HashMap<String, String> map, PageInfo re);
	
	ArrayList<Club> selectSearchPick(HashMap<String, String> map, PageInfo re);
	
	int searchForm(HashMap<String, String> map);

	ArrayList<Member> MemberList(int clubNo);
	
	
}
