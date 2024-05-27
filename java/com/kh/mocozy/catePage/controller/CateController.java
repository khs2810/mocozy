package com.kh.mocozy.catePage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class CateController {
	// BbsAction.java의 bbs_kind 액션 부분
	@RequestMapping(value = "/bbs_kind.nhn")
	   public ModelAndView bbs_kind( HttpServletRequest request, HttpServletResponse response) throws Exception {
		  String kind = request.getParameter("kind");
	      
		  /*페이징 처리 시작*/
		  int page = 1; 
	      int limit = 10;   
	      
	      if(request.getParameter("page") != null) {
	         page = Integer.parseInt(request.getParameter("page"));
	      }
	      
	      Map m = new HashMap();
	      m.put("page", page);
	      m.put("kind", "%" + kind + "%");
	      
	      int listcount = bbsService.getKindCount(m); 
	      
	      int maxpage = (listcount+limit-1)/limit;
	      int startpage = ((page-1)/10) * 10 + 1;
	      
	      int endpage = startpage + 10 - 1;
	      
	      if(endpage > maxpage) endpage = maxpage;
	      
	      if(endpage < page) page = endpage;
	      /*페이징 처리 끝*/
	      
	      List<BbsBean> bbslist = bbsService.getKindList(m); // 카테고리에 해당하는 부분만 불러오기
	      
	      ModelAndView bbsListM = new ModelAndView("bbs/bbs_list");
	      bbsListM.addObject("kind",kind);
	      bbsListM.addObject("page", page);
	      bbsListM.addObject("maxpage", maxpage);
	      bbsListM.addObject("startpage", startpage);
	      bbsListM.addObject("endpage", endpage);
	      bbsListM.addObject("listcount", listcount);
	      bbsListM.addObject("bbslist", bbslist);
	      
	      return bbsListM;
	   }//bbs_list() end
	//BbsDAOImpl.java 에서 getKindList부분
	public List<BbsBean> getKindList(Map m) throws Exception {
		      getSession(); //세션은 오브젝트니까
		      Object obj = m.get("kind");
		      List<BbsBean> list= null;
		      if(obj.equals("%all%")){ // 받아온게 all이면
		    	  list = sqlsession.selectList("bbs_list", m);
		      }else{
		    	  list = sqlsession.selectList("bbs_kindlist", m); //	    	  
		      }	      		
		      return list;
		   }
}
