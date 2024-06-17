package com.kh.mocozy.openDataApi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenDataApiController {

	@Value("${openData.api.key}")
	private String serviceKey;
	
	@RequestMapping("airApi.co")
	public String goApiAir() {
		return "common/apiAir";
	}
		
	@ResponseBody
	@RequestMapping(value = "airPlace", produces = "application/json; charset-UTF-8")
	public String getAirInfoPlace(String place) throws IOException {
		
		String url = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
		
		url += "?serviceKey=" + serviceKey;
		url += "&returnType=json";
		url += "&stationName=" + URLEncoder.encode(place, "UTF-8"); // 요청시 전달값에 한글이 있으면 인코딩 작업을 해야함
		url += "&numOfRows=" + "100";
		url += "&pageNo=" + "1";
		url += "&dataTerm=" + "DAILY";
		//자바 코드로 서버에서 서버로 요청을 보내야함
		// ** HttpURLConnection 객체를 이용해서 요청을 보내자
		
		//1. 요청하고자하는 url을 전달하면서 java.net.URL 객체 생성
		URL requestURL = new URL(url);
		
		//2. 만들어진 URL객체를 가지고 HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		//3. 요청에 필요한 Header설정하기
		urlConnection.setRequestMethod("POST");
		
		//4. 해당 api 서버로 요청 보낸후 입력데이터 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = "";
		String line;
		while((line = br.readLine()) != null) {
			responseText += line;
		}
		
		//사용 후 닫기
		br.close();
		urlConnection.disconnect();
		
		return responseText;
	}
	
}
