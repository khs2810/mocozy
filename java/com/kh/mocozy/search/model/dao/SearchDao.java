package com.kh.mocozy.search.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;

@Repository
public class SearchDao {
		/* searchListCount() */
	    public int searchCount(SqlSessionTemplate sqlSession) {
	    	return sqlSession.selectOne("searchMapper.searchCount");
		}
	    
		/* selectSearchList */
	    public ArrayList<Club> selectSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo re) {
	    	int offset = (re.getCurrentPage() - 1) * re.getBoardLimit();
			int limit = re.getBoardLimit();
			
			RowBounds rowBounds = new RowBounds(offset, limit);
			return (ArrayList)sqlSession.selectList("searchMapper.selectSearchList", map, rowBounds);
	    }
	    
	    // 순수 검색
		public int searchForm(SqlSessionTemplate sqlSession, HashMap<String, String> map){
			return sqlSession.selectOne("searchMapper.searchForm", map);
		}
		  
		// 카테고리 검색
		/* MenuSelectSearchRest */
		public ArrayList<Club> selectSearchCate(SqlSessionTemplate sqlSession, PageInfo re){
			int offset = (re.getCurrentPage() - 1) * re.getBoardLimit();
			int limit = re.getBoardLimit();
//			System.out.println(pi);
			RowBounds rowBounds = new RowBounds(offset, limit);
			
			return (ArrayList)sqlSession.selectList("searchMapper.selectSearchCate", null, rowBounds);
		} 
		
		// 클럽 검색
		/* selectSearchRest */
		public ArrayList<Club> selectSearchClub(SqlSessionTemplate sqlSession, PageInfo re){
			
			int offset = (re.getCurrentPage() - 1) * re.getBoardLimit();
			int limit = re.getBoardLimit();
//			System.out.println(pi);
			RowBounds rowBounds = new RowBounds(offset, limit);
			return (ArrayList)sqlSession.selectList("searchMapper.selectSearchClub", null, rowBounds);
		}
}

