package org.monwo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.monwo.dto.BoardDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.dto.SearchDTO;
import org.monwo.service.AdminService;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

//administrator = admin
//root
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private Util util;

	// http://localhost/admin/index
	// 경로----------------------
	@Resource(name = "adminService")
	private AdminService adminService;

	@GetMapping("/")
	public String index() {
		if (util.getSession().getAttribute("mid") != null) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMid((String)util.getSession().getAttribute("mid"));
			int grade = adminService.checkGrade(memberDTO);
			
			if (grade == 9) {
				return "/admin/index";
			}else{
				return "redirect:/error";
			}
		}else {
			return "redirect:../login";
		}
	}

	@GetMapping("/index")
	public String index2() {
		if (util.getSession().getAttribute("mid") != null) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMid((String)util.getSession().getAttribute("mid"));
			int grade = adminService.checkGrade(memberDTO);
			
			if (grade == 9) {
				return "/admin/index";
			}else{
				return "redirect:/error";
			}
		}else {
			return "redirect:../login";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@GetMapping("/join")
	public String join() {
		return "admin/join";
	}
	
	// 2024-03-04
	@GetMapping("/board")
	public String board(@RequestParam(name="pageNo", defaultValue="1") String pageNo,
			@RequestParam(name="perPage" ,defaultValue="1", required=false) String perPage,
			@RequestParam(name="search" ,required=false) String search,
			@RequestParam(name="searchTitle", required=false) String searchTitle,
			Model model) {
		
		if (util.getSession().getAttribute("mid") != null) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMid((String)util.getSession().getAttribute("mid"));
			int grade = adminService.checkGrade(memberDTO);
			
			if (grade == 9) {
				// 페이징, 검색, 한 화면에 보이는 게시글 수 변경( 페이징 할 때 같이 들어간다.)
				
				// 전체글 수에도 DTO에 보내기
				SearchDTO searchDTO = new SearchDTO();
				searchDTO.setSearch(search);
				searchDTO.setSearchTitle(searchTitle);
				
				// 게시판의 전체 글 수 뽑기
				int totalRecordCount = adminService.totalRecordCount(searchDTO);
				/*
				 * int currentPageNO = 1; if (util.str2Int(pageNo) > 0) { currentPageNO =
				 * Integer.parseInt(perPage); }
				 */
				//전자정부 페이징 만들기
				PaginationInfo paginationInfo = new PaginationInfo();
				paginationInfo.setCurrentPageNo(util.str2Int(pageNo));
				paginationInfo.setRecordCountPerPage(util.str2Int(perPage) * 10); // 한 페이지에 몇 개 보여줄 것인지 적는 곳
				paginationInfo.setPageSize(10); // 맨 밑에 몇 개의 페이지 갯수를 보여주는 곳
				paginationInfo.setTotalRecordCount(totalRecordCount);
				
				// 나머지 친구들은 밑으로 다시 내려왔다.
				searchDTO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
				searchDTO.setPageNo(paginationInfo.getFirstRecordIndex());
				
				List<BoardDTO> list = adminService.boardList(searchDTO); 
				model.addAttribute("list", list);
				model.addAttribute("paginationInfo", paginationInfo);
				model.addAttribute("pageNo", pageNo);
				model.addAttribute("perPage", perPage);
				model.addAttribute("search", search);
				model.addAttribute("searchTitle", searchTitle);
				return "/admin/board";
			}else{
				return "redirect:/error";
			}
		}else {
			return "redirect:../login";
		}

	}
	
	@GetMapping("/postDel")
		public String postDel(@RequestParam("no") int no) {

		if (util.getSession().getAttribute("mid") != null) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMid((String)util.getSession().getAttribute("mid"));
			int grade = adminService.checkGrade(memberDTO);
			
			if (grade == 9) {
				int result = adminService.postDel(no);
				return "redirect:/admin/board";
			}else{
				return "redirect:/error";
			}
		}else {
			return "redirect:../login";
		}

		}
	
	@GetMapping("/notice")
	public String notice() {
		
		return "/admin/notice";
	}
	
}
