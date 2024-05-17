package com.kh.mocozy.common.template;

import com.kh.mocozy.common.model.vo.PageInfo;

public class Pagination {
	/*
	int listCount;
	int currentPage;
	int pageLimit;
	int boardLimit;
	
	값을 전달 받아 maxPage, startPage, endPage값을 구하고 하나의 PageInfo객체로 만들어 반환
	*/
	
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = ((currentPage - 1) / pageLimit ) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		endPage = endPage > maxPage ? maxPage : endPage;
		
		return new PageInfo(listCount,
							currentPage, 
							pageLimit, 
							boardLimit, 
							maxPage, 
							startPage, 
							endPage 
							);
	}
}