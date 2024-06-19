package com.kh.mocozy.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//이메일 전송을 담당하는 컨트롤러
@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender sender;
	
	// 간단한 텍스트 이메일을 보내는 메서드
	@GetMapping("send")
	public String mail() {
		//메시지생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("비밀번호 재설정 요청"); // 이메일 제목 설정
		message.setText("비밀번호 뭘까~~요~? " ); // 이메일 내용 설정
		
		String[] to = {"khs2810@gmail.com"}; // 수신자 설정
		message.setTo(to);
		
		String[] cc = {"khs2810@gmail.com"}; // 참조자 설정
		message.setCc(cc);
		
		// 이메일 전송
		sender.send(message);
		
		// 메인 페이지로 리다이렉트
		return "redirect:/";
	}
	
//	//HTML메세지 메일 전송
//	@GetMapping("hypermail")
//	public String hyperMail() throws MessagingException {
//		MimeMessage message = sender.createMimeMessage();
//		
//		// 두 번째 인자를 false로 설정하여 단순 텍스트로 메일 생성
//		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
//		
//		String[] to = {"받는사람"}; // 수신자 설정
//		helper.setTo(to);
//		
//		String[] cc = {"참조자"}; // 참조자 설정
//		helper.setCc(cc);
//		
//		helper.setSubject("이메일 전송테스트3"); // 이메일 제목 설정
//		
//		String url = ServletUriComponentsBuilder
//				.fromCurrentContextPath()
//				.port(8890).path("/user")
//				.queryParam("user_id", "khjone0524")
//				.queryParam("uuid", "skldjhvnksdjbnv")
//				.toUriString();
//		
//		//두번째 인자를 true로 보낼시 html을 사용하겠다라는 의미
//		helper.setText("<a href='"+url+"'>웹사이트로 이동</a>", true);
//		sender.send(message);
//		
//		return "redirect:/";
//	}
//	
//	//file메일전송
//	@GetMapping("sendfile")
//	public String sendFile() throws MessagingException {
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//		
//		String[] to = {"받는사람"}; // 수신자 설정
//		message.setTo(to);
//		
//		String[] cc = {"참조자"}; // 참조자 설정
//		message.setCc(cc);
//		
//		helper.setSubject("이미지 전송 이메일 테스트"); // 이메일 제목 설정
//		
//		helper.setText("파일 전송 테스트입니다"); // 이메일 내용 설정
//		
//		//첨부파일 추가
//		DataSource source = new FileDataSource("C:\\Users\\user1\\Desktop\\다운로드.jpg");
//		helper.addAttachment(source.getName(), source);
//		
//		// 이메일 전송
//		sender.send(message);
//		
//		// 메인 페이지로 리다이렉트
//		return "redirect:/";
//	}
}