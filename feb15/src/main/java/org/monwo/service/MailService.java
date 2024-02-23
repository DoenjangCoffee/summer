package org.monwo.service;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	
	//여기서는 진짜 메일을 전송하는 역활을 할것이다.[문자만 들어올 수 있다.]
	public void mailTextSend(String email, String title, String content) throws EmailException {
		// 여기 밑에 적는 내용들은 모두 다 보내는 사람의 정보들이다.
		String emailAddr = ""; //여기에 적는 email은 보내는 사람 email이다.
		String name = "스프링살인마";
		String pw=""; // 보내는 사람 비밀번호
		String host="smtp-mail.outlook.com";
		int port=587;
		
		SimpleEmail se = new SimpleEmail(); 
		
		se.setCharset("UTF-8");
		se.setDebug(true);
		se.setHostName(host);
		se.setAuthentication(emailAddr, pw); // 보내는 사람
		se.setSmtpPort(port);
		se.setSubject(title);
		se.setFrom(emailAddr,name); // 보내는 사람
		se.setStartTLSEnabled(true); // 인증방법
		se.addTo(email);
		se.setMsg(content);
		se.send();

	}
	// 이미지, 그림, 글자 크기,굵기 등을 모두 다 사용 할 수 있다.
	public void mailHTMLSend(String email, String title, String content) throws EmailException {
		String emailAddr = ""; //여기에 적는 email은 보내는 사람 email이다.
		String name = "스프링살인마";
		String pw=""; // 보내는 사람 비밀번호
		String host="smtp-mail.outlook.com";
		int port=587;
		
		HtmlEmail he = new HtmlEmail();
		
		he.setCharset("UTF-8");
		he.setDebug(true);
		he.setHostName(host);
		he.setAuthentication(emailAddr, pw); // 보내는 사람
		he.setSmtpPort(port);
		he.setSubject(title);
		he.setFrom(emailAddr,name); // 보내는 사람
		he.setStartTLSEnabled(true); // 인증방법
		he.addTo(email);
		he.setMsg(content);
		
		EmailAttachment file = new EmailAttachment();
		file.setPath("c:\\temp\\img.gif"); // 첨부파일 보내기 
		he.attach(file);
		he.send();
		
	}

}
