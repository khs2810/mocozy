package com.kh.mocozy.catePage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.catePage.service.CateService;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class CateController {

    @Autowired
    private CateService cService;
    
    @Autowired
    private AdminNoticeService anService;
    
    //전체보기
    @RequestMapping("cateAll.ct")
    public String showcateAll(@RequestParam(value="cpage", defaultValue="1") int currentPage, String order, Model model) {  
        int cateAllList = cService.getClublist(); 
        ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
        model.addAttribute("cateAllList", cateAllList);
        model.addAttribute("getnoticeBanner", getnoticeBanner);
        return (cateAllList == 0) ? "common/errorPage" : "categories/cateView/cateAll";
    }
    
    //전체Ajax
    @ResponseBody
    @RequestMapping(value="cateAllAjax.ct", produces="application/json; charset=UTF-8")
    public String cateAllAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String order, Model model) {    
        int cateAllList = cService.getClublist(); 
        PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 8, 8);
        ArrayList<Club> catelist = cService.selectcateAll(pi, order);
        for (Club c : catelist){
            ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);    
        }
        return new Gson().toJson(catelist);
    }
    
    //카테고리
    @RequestMapping("cateKey.ct")
    public String cateKey(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key, String order) { 
        int cateAllList = cService.getClublist(); 
        ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
        String cname = getCnameByKey(key);
        model.addAttribute("cname", cname);
        model.addAttribute("key", key);
        model.addAttribute("cateAllList", cateAllList);
        model.addAttribute("getnoticeBanner", getnoticeBanner);
        return (cateAllList == 0) ? "common/errorPage" : "categories/cateView/cateKey";
    }
    
    //카테고리Ajax
    @ResponseBody
    @RequestMapping(value="cateKeyAjax.ct", produces="application/json; charset=UTF-8")
    public String cateKeyAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key, String order) {      
        int cateAllList = cService.getClublist(); 
        PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 8, 8);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("order", order);
        ArrayList<Club> catelist = cService.selectCateFilter(map, pi);
        for (Club c : catelist){
            ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);  
        }
        model.addAttribute("key", key);
        model.addAttribute("catelist", catelist);
        return new Gson().toJson(catelist);
    }
    
    //인기순
    @RequestMapping("catePick.ct")
    public String catePick(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String order) { 
        int cateAllList = cService.getClublist(); 
        ArrayList<Notice> getnoticeBanner = anService.getNoticeBannerList();
        String cname = getCnameByOrder(order);
        model.addAttribute("order", order);
        model.addAttribute("cname", cname);
        model.addAttribute("cateAllList", cateAllList);
        model.addAttribute("getnoticeBanner", getnoticeBanner);
        return (cateAllList == 0) ? "common/errorPage" : "categories/cateBest/catePick";
    }
    
    //인기순 Ajax
    @ResponseBody
    @RequestMapping(value="catePickAjax.ct", produces="application/json; charset=UTF-8")
    public String catePickAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model, String key, String order) {      
        int cateAllList = cService.getClublist(); 
        PageInfo pi = Pagination.getPageInfo(cateAllList, currentPage, 8, 8);
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        map.put("order", order);
        ArrayList<Club> catelist = cService.selectCatePick(map, pi);
        for (Club c : catelist){
            ArrayList<Member> memberList = cService.MemberList(c.getClubNo());
            ArrayList<String> imgs = new ArrayList<String>();
            for (Member m : memberList) {
                imgs.add(m.getProfileImg());
            }
            c.setProfileImg(imgs);  
        }
        model.addAttribute("key", key);
        model.addAttribute("catelist", catelist);
        return new Gson().toJson(catelist);
    }
    
    //카테고리 이름 가져오기
    private String getCnameByKey(String key) {
        if (key.equals("문화, 예술") || key.equals("푸드, 드링크")) {
            return "문화생활";
        } else if(key.equals("자기계발") || key.equals("재테크") || key.equals("외국어"))  {
            return "미래발전";
        } else if(key.equals("액티비티") || key.equals("여행 · 동행")) {
            return "스포츠";
        } else if(key.equals("취미") || key.equals("파티  · 게임")) {
            return "취미";
        }
        return "";
    }
    
    //정렬순 이름 가져오기
    private String getCnameByOrder(String order) {
        if (order.equals("club_no")) {
            return "최신순 모임";
        } else if(order.equals("pickCount")) {
            return "인기순 모임";
        } else if(order.equals("count")){
            return "조회순 모임";
        } 
        return "";
    }
}