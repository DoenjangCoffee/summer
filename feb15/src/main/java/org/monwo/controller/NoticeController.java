package org.monwo.controller;

import javax.annotation.Resource;

import org.monwo.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	@Resource(name = "noticeService")
	private NoticeService ns;
	
	@GetMapping
	public String notice() {
		return "notice";
	}
}
