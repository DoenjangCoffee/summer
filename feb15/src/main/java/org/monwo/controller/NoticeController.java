package org.monwo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.monwo.dto.NoticeDTO;
import org.monwo.service.NoticeService;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {
	@Autowired
	Util util;
	@Resource(name = "noticeService")
	private NoticeService ns;
	
	// 요구사항 확인하기 ( 2024-02-27 )
	@GetMapping("/notice")
	public String notice(Model model) {
		List<NoticeDTO> list = ns.noticeList();
		model.addAttribute("list",list);
		return "notice";
	}
	
	// 공지 글쓰기 => admin 관리자 화면에서 글쓰기가 가능하도록 한다.
	@GetMapping("/admin/noticeWrite")
	public String noticeWrite() {
		return "admin/noticeWrite"; // /views/admin/noticeWrite.jsp로 찾아가게된다.
	}
	
	// 공지사항 글쓰기
	@PostMapping("/admin/noticeWrite")
	public String noticeWrite(NoticeDTO dto) {
		ns.noticeWrite(dto);
		return "redirect:/notice";
	}
	
	// 공지사항 상세보기
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("no") String no, Model model) {
		int nno = util.str2Int(no);
// if문을 작성 할때 가장 많이 걸리는것을 최상단에 적어주는 것이 좋다.		
		if (nno == 0) { // 들어오는 데이터 검사
			return "redirect:/error";
		}else {
			NoticeDTO detail = ns.detail(nno);
			if (detail.getNno() != 0) { // 혹시 없는 게시물에 들어가려고 했을때 막는 코드
				model.addAttribute("detail", detail);
				return "noticeDetail";
			} else {
				return "redirect:/error";
			}
		}
	}
	
	@GetMapping("/noticeDel^{no}")
	public String noticeDel(@PathVariable("no") int no) {
		ns.noticeDel(no);
		return "redirect:/notice";
				
	}
}
