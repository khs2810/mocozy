package com.kh.mocozy.search.service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;

@Service
public interface SearchService {
	public int searchCount();
	
	public ArrayList<Club> selectSearchList(HashMap<String, String> map, PageInfo re);
	
	public int searchForm(HashMap<String, String> map);

	public ArrayList<Club> selectSearchCate(PageInfo re);
	
	public ArrayList<Club> selectSearchClub(PageInfo re);
}
