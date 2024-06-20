package com.kh.mocozy.mail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Email {
public static void main(String[] args) {
		
		//MIME 형식의 메일을 보내기 위해서는 JavaMailSender인터페이스를 사용한다.
		//계정설정
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("mocozy@gmail.com");
		sender.setPassword("hwkn jmqb cxyd oxwt");
		
		//옵션설정
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		
		sender.setJavaMailProperties(prop);
		
		//메시지생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("이메일 전송 테스트");
		message.setText("이메일을 테스트하도록 하겠습니다");
		
		String[] to = {"khs2810@gmail.com"};
		message.setTo(to);
		
		String[] cc = {"khs2810@gmail.com"};
		message.setCc(cc);
		
		sender.send(message);
	}
}