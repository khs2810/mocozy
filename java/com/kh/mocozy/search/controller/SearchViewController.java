package com.kh.mocozy.search.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.search.service.SearchService;

@Controller
public class SearchViewController {

    @Autowired
    private SearchService sService;
    
    //검색
    @GetMapping("searchFormView.sc")
    public String searchForm(@RequestParam("keyword") String keyword, @RequestParam("rpage") int currentPage, Model model) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keyword", keyword);
        
        //키워드로 검색한 클럽 수 + 키워드에 맞는 클럽 호출
        int clubCount = sService.searchForm(map);
        
        PageInfo re = Pagination.getPageInfo(clubCount, currentPage, 1, 9);
        ArrayList<Club> clist = sService.selectSearchList(map, re);
        
		for (Club c : clist){
		    ArrayList<Member> memberList = sService.MemberList(c.getClubNo());
		    ArrayList<String> imgs = new ArrayList<String>();
		    for (Member m : memberList) {
		    	imgs.add(m.getProfileImg());
		    }
		    c.setProfileImg(imgs);    
		}
		
		//Club의 count 높은 순으로 정렬
	    Collections.sort(clist, new Comparator<Club>() {
	        @Override
	        public int compare(Club c1, Club c2) {
	            return Integer.compare(c2.getCount(), c1.getCount());
	        }
	    });
	    
        model.addAttribute("clist", clist);
        model.addAttribute("re", re);
        model.addAttribute("keyword", keyword);
        
        if (clubCount == 0) { //검색결과 없음
        	return "search/searchError";
		} else { //검색결과있음
			return "searchView/searchMainView";
		}
    }
}