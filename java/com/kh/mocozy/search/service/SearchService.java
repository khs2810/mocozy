package com.kh.mocozy.search.service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.member.model.vo.Member;

@Service
public interface SearchService {

	
	int searchForm(HashMap<String, String> map);
	ArrayList<Club> searchFormAjax(HashMap<String, String> map, PageInfo re);

	ArrayList<Member> MemberList(int clubNo);
	
	
}
