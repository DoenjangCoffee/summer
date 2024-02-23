package org.monwo.controller;

import org.apache.commons.mail.EmailException;
import org.monwo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

	@Autowired
	private MailService ms;
	
	@GetMapping("/mail")
	public String mail() {
// 제작 순서
// menu에 추가 => controller 생성 => jsp 생성 => 화면 구성 => service에서 메일 보내기
		// 로그인 한 사용자만 접근이 가능하다.
		
		return "mail";
	}
	
	@PostMapping("/mail")
	// jsp에서 받아서 => Controller => Service에서 메일 발송
	public String mail(@RequestParam("email") String email,@RequestParam("title") String title, @RequestParam("content") String content) throws EmailException {
		//ms.mailTextSend(email, title, content); // Service에 하청 주기
		ms.mailHTMLSend(email, title, content); 
		return "redirect:/mail";
	}
}
