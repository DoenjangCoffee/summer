package org.monwo.controller;

import org.apache.commons.mail.EmailException;
import org.apache.ibatis.annotations.Param;
import org.monwo.dto.BoardDTO;
import org.monwo.service.BoardService;
import org.monwo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
	@Autowired
	private BoardService boardservice;
	@Autowired
	private RestService restService;
	
	@PostMapping("/restDetail")
	public BoardDTO restDetail(@Param("no") int no) {
		//System.out.println("restDetail : "+no);
		BoardDTO detail = boardservice.detail(no);
		//System.out.println(detail.getBoard_title());
		//System.out.println(detail.getBoard_content());
		return detail;
	}
	
	@PostMapping("/emailAuth")
	public int emailAuth() throws EmailException {
		return restService.sendEmail();
				
	}
}
