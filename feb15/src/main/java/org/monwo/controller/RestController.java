package org.monwo.controller;

import org.apache.ibatis.annotations.Param;
import org.monwo.dto.BoardDTO;
import org.monwo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	@Autowired
	private BoardService boardservice;
	
	@PostMapping("/restDetail")
	public @ResponseBody BoardDTO restDetail(@Param("no") int no) {
		//System.out.println("restDetail : "+no);
		BoardDTO detail = boardservice.detail(no);
		//System.out.println(detail.getBoard_title());
		//System.out.println(detail.getBoard_content());
		return detail;
	}
}
