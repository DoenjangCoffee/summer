package org.monwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("/error")
	public String error() {
		
		return "error/error"; //위에 경로 /WEB-INF/views/error/error.jsp로 가기 때문에 앞에 슬러시 생략 가능 
	}
}
