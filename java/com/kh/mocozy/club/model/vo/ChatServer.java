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
import com.kh.mocozy.club.service.ChatService;
import com.kh.mocozy.member.model.vo.Member;
import com.kh.mocozy.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ChatService chatService;
	
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();
//	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	// 클라이언트가 연결을 맺을 때 호출되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Member loginUser = (Member)session.getAttributes().get("loginUser");
		String nick = loginUser.getNickname();
		log.info("{} 연결됨...", nick);
		
		userSessions.put(nick, session);
	}
	
	// 클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Member loginUser = (Member)session.getAttributes().get("loginUser");
		String nick = loginUser.getNickname();
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		log.info("message : {}", obj);
		String msgCon = obj.get("message").getAsString();
		int target = obj.get("target").getAsInt();
		int chatNo = obj.get("chatNo").getAsInt();
		int userNo = obj.get("userNo").getAsInt();
		
		Message msg = new Message();
		msg.setMessageContent(msgCon);
		msg.setSenderNo(userNo);
		msg.setNick(nick);
		msg.setSendTime(new java.sql.Timestamp(new Date().getTime()));
		msg.setChatroomNo(chatNo);
		ChatRoom targetChat = chatService.selectChatRoomByNo(chatNo);
		int masterNo = targetChat.getMasterNo();
		
		int targetNo;
		if(userNo != masterNo) {
			System.out.println("userNo랑 masterNo가 다름");
			System.out.println("targetNo : " + target);
			System.out.println("senderNo : " + userNo);
			int targetChatCno = targetChat.getClubNo();
			System.out.println("targetChatNo : " + targetChatCno);
			System.out.println("masterNo : " + masterNo);
			targetNo = targetChat.getMasterNo();
		} else {
			targetNo = targetChat.getTargetNo();
			System.out.println("userNo랑 masterNo가 같음");
			System.out.println("targetNo : " + target);
			System.out.println("senderNo : " + userNo);
			System.out.println("masterNo : " + masterNo);
		}
		
		msg.setTargetNo(targetNo);
		System.out.println("msg : " + msg);
		
		int result = chatService.insertMessage(msg);
		if (result > 0) {
			System.out.println("result가 0보다 큼");
			sendMessageUser(memberService.selectNicknameByUserNo(targetNo), msg);
		} else {
			System.out.println("DB에 메세지 생성 실패");
		}
//		sendMessageUser(memberService.selectNicknameByUserNo(targetNo), msg);
	}
	
	// 특정 사용자에게 메세지를 전송하는 메소드
	private void sendMessageUser(String targetNick, Message msg) {
		WebSocketSession targetSession = userSessions.get(targetNick);
		WebSocketSession mySession = userSessions.get(msg.getNick());
		System.out.println("userSessions : " + userSessions);
		System.out.println("targetSession : " + targetSession);
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
