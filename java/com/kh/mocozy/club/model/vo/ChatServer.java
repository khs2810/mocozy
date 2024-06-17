package com.kh.mocozy.club.model.vo;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler {
	
	@Autowired
	private MemberService memberService;
//	private ChatService chatService;
	
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();
//	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	// 클라이언트가 연결을 맺을 때 호출되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Member loginUser = (Member)session.getAttributes().get("loginUser");
		String nick = loginUser.getNickname();
		log.info("{} 연결됨...", nick);
	}
	
	// 클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Member loginUser = (Member)session.getAttributes().get("loginUser");
		String nick = loginUser.getNickname();
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		
		log.info("message : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		Message msg = new Message();
		msg.setMessageContent(obj.get("message").getAsString());
		msg.setSenderNo(Integer.parseInt(obj.get("message").getAsString()));
		msg.setSendTime(new java.sql.Timestamp(new Date().getTime()));
		System.out.println("msg : " + msg);
		sendMessageUser(obj.get("target").getAsString(), msg);
	}
	
	// 특정 사용자에게 메세지를 전송하는 메소드
	private void sendMessageUser(String targetNick, Message msg) {
		WebSocketSession targetSession = userSessions.get(targetNick);
		WebSocketSession mySession = userSessions.get(msg.getSenderNo());
		System.out.println("targetSEssion : " + targetSession);
		System.out.println("mySession : " + mySession);
		if (targetSession != null && targetSession.isOpen()) {
			System.out.println("연결!");
			String str = new Gson().toJson(msg);
			TextMessage tmsg = new TextMessage(str);
			
			try {
				mySession.sendMessage(tmsg);
				targetSession.sendMessage(tmsg);
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결x");
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Member loginUser = (Member)session.getAttributes().get("loginUser");
		String nick = loginUser.getNickname();
		
		log.info("{} 연결 끊김...", nick);
		userSessions.remove(nick);
	}
}
