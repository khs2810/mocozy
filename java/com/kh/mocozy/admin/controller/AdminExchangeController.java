package com.kh.mocozy.admin.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mocozy.admin.service.AdminClubService;
import com.kh.mocozy.admin.service.AdminNoticeService;
import com.kh.mocozy.admin.service.AdminService;
import com.kh.mocozy.admin.service.AdminUserlistService;
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.member.service.MemberService;
import com.kh.mocozy.point.service.PointService;

@Controller
public class AdminExchangeController {
	private static final float USD_RATE = 0.00081f;
	private static final float JPY_RATE = 0.095f;
	private static final float CNY_RATE = 0.0051f;
	private static final float GBP_RATE = 0.00062f;
	private static final float EUR_RATE = 0.00074f;

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

	@GetMapping("/calc")
    public ModelAndView calculate(@RequestParam(required = false) String command,
                                  @RequestParam(required = false) String won,
                                  @RequestParam(required = false) String operator) {
        ModelAndView mav = new ModelAndView();

        if (command != null && command.equals("calculate") && won != null && operator != null) {
            float rate = getExchangeRate(operator);
            if (rate != -1) { // Check for valid rate
                String result = calculate(Float.parseFloat(won), rate);
                mav.addObject("result", result);
                mav.setViewName("result");
            } else {
                mav.addObject("error", "Invalid operator");
                mav.setViewName("error");
            }
        } else {
            mav.setViewName("calc");
        }

        return mav;
    }


	private static String calculate(float won, float rate) {
        return String.format("%.6f", won / rate);
    }

    private float getExchangeRate(String currency) {
        String apiKey = "w1Y81VEGFsQI61nPkmINZPc5hppLz1im"; // Replace with your API key
        String apiUrl = "https://www.koreaexim.go.kr/ir/HPHKIR020M01?apino=2&viewtype=C&searchselect=&searchword="; // Replace with your API URL

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ((Number) jsonObject.get(currency.toUpperCase())).floatValue();
    }
}
