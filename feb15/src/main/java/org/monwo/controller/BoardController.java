package org.monwo.controller;

import java.util.List;

import org.monwo.dto.BoardDTO;
import org.monwo.dto.CommentDTO;
import org.monwo.dto.WriteDTO;
import org.monwo.service.BoardService;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardservice;
	@Autowired
	private Util util;
	
	// 페이징 추가하기 2024-02-20
	@GetMapping({"/","/board"})
	public String board(@RequestParam(value = "pageNo", required = false) String no ,Model model) {
		// pageNo가 없거나 오지 않는다면 1로 만들어주는 코드
		int currentPageNo = 1;
		if (util.str2Int(no) > 0) { // 여기는 나중에 수정하기
			currentPageNo = Integer.parseInt(no);
		}
		
		// 전체 글 수 : int totalRecordCount
		int totalRecordCount = boardservice.totalRecordCount();
		System.out.println("totalCount : "+totalRecordCount);
		
		//pagination
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); // 현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); // 한 페이지에 게시되는 게시물 건수 
		paginationInfo.setPageSize(10); // 페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalRecordCount); // 전체 게시물 건수

		//페이징 관련 정보가 있는 PaginationInfo객체를 
		List<BoardDTO> list = boardservice.boardList(paginationInfo.getFirstRecordIndex());
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("list", list);
		return "board";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/detail")
	public String detail(@RequestParam(value="no", defaultValue="10",required=true) String no, Model model) { // no라고 들어오는 parameter를 int 값에 no를 담아준다.[spring이 알아서 해준다.(대신 문자들어오면 깨진단다.)]
		//오는 no값 잡기1
		//String no = request.getParameter("no");
		int reNo = util.str2Int(no);
		if (reNo != 0) {
			//0이 아니다. = 정상 : DB에 물어보기 / 값 가져오기 / 붙이기 / 1. 이동하기
			BoardDTO detail = boardservice.detail(reNo);
			model.addAttribute("detail", detail);
			// 2024-02-19 댓글 뽑기
			if (detail.getComment() > 0) {
				List<CommentDTO> commentsList = boardservice.commentsList(reNo);
				model.addAttribute("commentsList",commentsList);				
			}
			return "detail";
		} else {
			//0이다. = 비정상 : 에러로 페이지 이동하기
			//return "/error/error"; //error폴더의 error.jsp로 가도록 한다.
			return "redirect:/error"; // controller에 있는 error매핑을 실행한다.
		}
		//System.out.println(util.str2Int(request.getParameter("no"))); // 숫자면 자신의 숫자, 문자면 0을 출력 
	}
	@PostMapping("/write")
	public String write(WriteDTO dto) { //내용 + 제목 받고 => DB에 저장 => board로 보내기
		//System.out.println(dto.getTitle());
		//System.out.println(dto.getContent());
		int result = boardservice.write(dto);
		
		if (util.getSession().getAttribute("mid") != null) {
			if (result == 1) {
				return "redirect:/detail?no="+dto.getBoard_no();
			} else {
				return "redirect:/error";
			}
		}else {
			return "redirect:/login?error=2048";
		}
		//System.out.println("결과는 : "+result);
		// 추후 세션관련 작업을 더 해야한다. [2024.02.16 기준]
}
	@GetMapping("/write")
	public String write() {// get방식으로 들어오는 것도 차단 하기 위해서 만들었다.
		return "redirect:/login?error= 2048";
	}

	//댓글 만들기 24-02-19 와야되는것 : 글번호, 댓글 내용, 글쓴이(session으로 받아와야한다.)
	@PostMapping("/commentWrite")
	public String commentWrite(CommentDTO comment) {
		//System.out.println(comment.getNo());
		//System.out.println(comment.getComment());
		//HttpSession session = request.getSession();
		//comment.setMid((String)session.getAttribute("mid"));
		int result = boardservice.commentWrite(comment);
		// 로그인 여부 검사
		if (util.getSession().getAttribute("mid") != null) {
			if (result == 1) {
				return "redirect:/detail?no="+comment.getNo();
			} else {
				return "redirect:/error";
			}
		}else {
			return "redirect:/login";
		}
		//System.out.println("댓글쓰기 결과 : "+result);
	}
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		// 로그인 여부를 확인하고 지울 수 있게 만든다.
		if (util.getSession().getAttribute("mid") != null) {
			//System.out.println("no : "+no);
			int result = boardservice.postDel(no);
			System.out.println("result : "+result);
			return "redirect:/board";
		}else {
			return "redirect:/login";
		}
	}

	// 댓글 삭제 2024-02-21 댓글번호 +  댓글을 썻던 글 번호
	@GetMapping("/deleteComment")
	public String deleteComment(@RequestParam("no") int no, @RequestParam("cno") int cno) {
		//System.out.println("no : "+no); //no = 글번호
		//System.out.println("cno : "+cno); // cno = 댓글번호
		int result = boardservice.deleteComment(no,cno);
		if (util.getSession().getAttribute("mid") != null) {
			if (result == 1) {
				return "redirect:/detail?no="+no;
			} else {
				return "redirect:/error";
			}
		}else {
			return "redirect:/login";
		}
	}
	@GetMapping("/likeUp")
	public String likeUp(@RequestParam("no") String no, @RequestParam("cno") String cno) {
		System.out.println("no : "+no);
		System.out.println("cno : "+cno);
		if (util.getSession().getAttribute("mid") != null && util.intCheck(cno) && util.intCheck(no)) {
			CommentDTO dto = new CommentDTO();
			dto.setBoard_no(util.str2Int(no));
			dto.setNo(util.str2Int(cno));
			int result = boardservice.likeUp(dto);
			return "redirect:/detail?no="+dto.getBoard_no();
		}else {
			return "redirect:/error";
		}
	}
}
