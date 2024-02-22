package org.monwo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.monwo.dto.LoginDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.service.LoginService;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	Util util;
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//System.out.println(id+" : "+pw);
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setId(id);
		loginDTO.setPw(pw);
		
		LoginDTO login = loginService.login(loginDTO);
		if (login.getCount() == 1 && login.getMcount() < 5) {
			if (login.getPw().equals(loginDTO.getPw())) { // 로그인 시도하는 사용자 비밀번호 비교
				//세션 만들기.
				HttpSession session = request.getSession();
				session.setAttribute("mid",id);
				session.setAttribute("mname", login.getMname());
				
				// 해당 id의 mcount를 0으로 만들기
				loginService.mcountReset(loginDTO);
				return "redirect:/index";
			}else {
				loginService.mcountUp(loginDTO);
				return "redirect:/login?count="+login.getMcount();
			}
		}else if(login.getMcount() < 5){
			loginService.mcountUp(loginDTO);
			return "redirect:/login?count="+login.getMcount();
		}else {
			// 해당 id의 mcount를 +1 시키기
			// 잘못된 로그인 경우 로그인 창으로 이동하기 = 5번 시도 로그인시도를 했으면 잠그기
			return "redirect:/login?count="+login.getMcount();
		}
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {
			session.removeAttribute("mid");
		}
		if (session.getAttribute("mname") != null) {
			session.removeAttribute("mname");// <= 이거 확인하기
		}
		session.invalidate(); // <= 이것도 확인하기
		
		return "redirect:/login";
	}
	// http://172.30.1.200/myinfo@monwo
	@GetMapping("/myinfo@{id}")
	public String myinfo(@PathVariable("id") String id) throws EmailException {
		if (util.getSession().getAttribute("mid") != null) {
			
			// 인증 요청 하기 = ajax용으로 빼두기
			//loginService.myInfo();
			
			
			return "myinfo";
		}else {
			return "redirect:/login";
		}
		
		
	}
}
