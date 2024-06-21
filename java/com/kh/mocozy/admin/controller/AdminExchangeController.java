package com.kh.mocozy.admin.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.kh.mocozy.admin.service.AdminClubService;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.admin.service.AdminService;
import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.board.model.vo.Notice;
import com.kh.mocozy.club.model.vo.ChatRoom;
import com.kh.mocozy.club.model.vo.Club;
import com.kh.mocozy.club.model.vo.Message;
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.common.model.vo.PageInfo;
import com.kh.mocozy.common.template.Pagination;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.model.vo.Point;
import com.kh.mocozy.point.model.vo.PointDTO;
import com.kh.mocozy.point.service.PointService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class AdminExchangeController {
	
	@Autowired
	private AdminService adService;
	 
    @Autowired
    private AdminClubService acService;
    
    @Autowired
    private AdminUserlistService auService;
    
    @Autowired
    private AdminNoticeService anService;
    
    @Autowired
    private PointService pointService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private ChatService chatService;
    

@RequestMapping("adminExchange.ad")
public BigDecimal getExchangeRate() {
    String authKey = "<발급받은 인증키>";
    String searchDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
    String dataType = "AP01";
    BigDecimal exchangeRate = null;

    try {
        // Request URL
        String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + authKey + "&searchdate=" + searchDate + "&data=" + dataType;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONParser parser = new JSONParser();
        JSONArray exchangeRateInfoList = (JSONArray) parser.parse(response);

        // KRW -> USD에 대한 환율 정보 조회
        for (Object o : exchangeRateInfoList) {
            JSONObject exchangeRateInfo = (JSONObject) o;
            if (exchangeRateInfo.get("cur_unit").equals("USD")) {

                // 쉼표가 포함되어 String 형태로 들어오는 데이터를 Double로 파싱하기 위한 부분
                NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
                exchangeRate = new BigDecimal(format.parse(exchangeRateInfo.get("deal_bas_r").toString()).doubleValue());
            }
        }
    } catch (ParseException | java.text.ParseException e) {
        throw new RuntimeException(e);
    }

    if (exchangeRate == null) {
        exchangeRate = getExchangeRate();
    }

    return exchangeRate;
}
}
