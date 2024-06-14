//package com.kh.mocozy.naverPay.controller;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import com.google.gson.Gson;
//import com.kh.mocozy.member.model.vo.Member;
//
//@Controller
//public class NaverPayController {
//	
//	private static final String Host = "https://dev.apis.naver.com";
//	
//	@Value("${naver.api.me.id}")
//	private String naverMeId;
//	
//	@Value("${naver.api.client.id}")
//	private String naverClId;
//	
//	@Value("${naver.api.client.secret}")
//	private String naverClSecret;
//	
//	@Value("${naver.api.chain.id}")
//	private String naverChId;
//	
//	
//	@ResponseBody
//	@RequestMapping(value = "ajaxPointChargeNpay.pt", produces = "application/json; charset-UTF-8")
//	public String ajaxInsertNoticeReply(Member m, String pointType, HttpSession session) throws RestClientException, URISyntaxException {
//		System.out.println(m);
//		System.out.println(pointType);
//		
//		RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        System.out.println(1);
//        // Server Request Header : 서버 요청 헤더
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Naver-Client-Id", naverClId); 
//        headers.add("X-Naver-Client-Secret", naverClSecret); 
//        headers.add("Content-Type", "application/json");
//        System.out.println(2);
//     // Server Request Body : 서버 요청 본문
//        Map<String, Object> params = new HashMap<String, Object>();
//        Map<String, Object> product = new HashMap<String, Object>();
//        product.put("categoryType", "ETC");
//        product.put("categoryId", "ETC");
//        product.put("uid", "107922211");
//        product.put("name", m.getPoint() + "pt");
//        product.put("count", 1);
//        
//        params.put("merchantPayKey", naverMeId); // 가맹점 코드 - 테스트용
//        params.put("productName", m.getPoint() + "pt"); // 상품 명
//        params.put("productCount", "1"); // 상품 수량
//        params.put("totalPayAmount", m.getPoint() + ""); // 상품 가격
//        params.put("taxScopeAmount", m.getPoint() + ""); // 상품 비과세 금액
//        params.put("taxExScopeAmount", "0");
//        params.put("returnUrl", "http://localhost:8890/mocozy/"); // 성공시 url
//        params.put("productItems", product);
//        
//        System.out.println(3);
//        HttpEntity<Map<String, Object>> body = new HttpEntity<Map<String, Object>>(params, headers);
//        System.out.println(body);
//        // 헤더와 바디 붙이기
//        ResponseEntity<Map> response = restTemplate.postForEntity(new URI(Host + "/naverpay-partner/naverpay/payments/v2/reserve"), body, Map.class);
//        Map<String, String> responseBody = response.getBody();
//        
//        System.out.println(responseBody);
//        
//		return new Gson().toJson("YYY");
//	}
//
//}
