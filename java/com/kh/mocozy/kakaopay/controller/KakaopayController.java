package com.kh.mocozy.kakaopay.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.kh.mocozy.kakaopay.vo.KakaoPayDTO;
import com.kh.mocozy.member.model.vo.Member;

@Controller
public class KakaopayController {
	private static final String Host = "https://open-api.kakaopay.com/online";
	
	@Value("${kakao.api.sc.key}")
	private String kakaoScKey;
	
	@RequestMapping("kakaopay.pt")
	public String kakaopayPayment(Member m, HttpSession session, Model model) throws RestClientException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        
        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + kakaoScKey); // 어드민 키
        headers.add("Content-Type", "application/json");
        
        // Server Request Body : 서버 요청 본문
        Map<String, String> params = new HashMap<String, String>();

        params.put("cid", "TC0ONETIME"); // 가맹점 코드 - 테스트용
        params.put("partner_order_id", "1111"); // 주문 번호
        params.put("partner_user_id", m.getUserId()); // 회원 아이디
        params.put("item_name", m.getPoint() + "pt"); // 상품 명
        params.put("quantity", "1"); // 상품 수량
        params.put("total_amount", m.getPoint() + ""); // 상품 가격
        params.put("tax_free_amount", "0"); // 상품 비과세 금액
        params.put("approval_url", "http://localhost:8890/mocozy/charge.pt?userNo=" + m.getUserNo() 
        																 + "&userId=" + m.getUserId()
        																 + "&userPwd=" + m.getUserPwd()
        																 + "&point=" + m.getPoint()); // 성공시 url
        params.put("cancel_url", "http://localhost:8890/mocozy/common/errorPage"); // 실패시 url
        params.put("fail_url", "http://localhost:8890/mocozy/common/errorPage");
        
        
        HttpEntity<Map<String, String>> body = new HttpEntity<Map<String, String>>(params, headers);
        // 헤더와 바디 붙이기
        ResponseEntity<Map> response = restTemplate.postForEntity(new URI(Host + "/v1/payment/ready"), body, Map.class);
        Map<String, String> responseBody = response.getBody();
        
        String returnUrl = responseBody.get("next_redirect_pc_url");
        
        return "redirect:" + returnUrl;
	}
	
	@RequestMapping("kakaopayInClub.pt")
	public String kakaopayPaymentInClub(Member m, int cno, String answer, String dDay, String evDate, HttpSession session, Model model) throws RestClientException, URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        
        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + kakaoScKey); // 어드민 키
        headers.add("Content-Type", "application/json");
        
        // Server Request Body : 서버 요청 본문
        Map<String, String> params = new HashMap<String, String>();

        params.put("cid", "TC0ONETIME"); // 가맹점 코드 - 테스트용
        params.put("partner_order_id", "1111"); // 주문 번호
        params.put("partner_user_id", m.getUserId()); // 회원 아이디
        params.put("item_name", m.getPoint() + "pt"); // 상품 명
        params.put("quantity", "1"); // 상품 수량
        params.put("total_amount", m.getPoint() + ""); // 상품 가격
        params.put("tax_free_amount", "0"); // 상품 비과세 금액
        params.put("approval_url", "http://localhost:8890/mocozy/chargeInClub.pt?userNo=" + m.getUserNo() 
        																 + "&userId=" + m.getUserId()
        																 + "&userPwd=" + m.getUserPwd()
        																 + "&point=" + m.getPoint()
        																 + "&cno=" + cno
        																 + "&answer=" + answer
        																 + "&dDay=" + dDay
        																 + "&evDate=" + evDate
        																 ); // 성공시 url
        params.put("cancel_url", "http://localhost:8890/mocozy/common/errorPage"); // 실패시 url
        params.put("fail_url", "http://localhost:8890/mocozy/common/errorPage");
        
        
        HttpEntity<Map<String, String>> body = new HttpEntity<Map<String, String>>(params, headers);
        // 헤더와 바디 붙이기
        ResponseEntity<Map> response = restTemplate.postForEntity(new URI(Host + "/v1/payment/ready"), body, Map.class);
        Map<String, String> responseBody = response.getBody();
        
        String returnUrl = responseBody.get("next_redirect_pc_url");
        
        return "redirect:" + returnUrl;
	}
}
