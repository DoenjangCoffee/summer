package org.monwo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.monwo.dao.BoardDAO;
import org.monwo.dto.BoardDTO;
import org.monwo.dto.CommentDTO;
import org.monwo.dto.WriteDTO;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	@Autowired
	private Util util;
	
	public List<BoardDTO> boardList(int pageNo) {
		return dao.boardList(pageNo);
	}

	public BoardDTO detail(int no) {
		return dao.detail(no);
	}

	public int write(WriteDTO dto) {
		/*
		 * HttpServletRequest request = util.req(); 
		 * HttpSession session = request.getSession();
		 */
		HttpSession session = util.getSession();
		//dto.setMid((String)util.getSession().getAttribute("mid")) => 밑에 줄과 동일한 뜻을 나타낸다.
		dto.setMid((String)session.getAttribute("mid"));
		dto.setIp(util.getIp());
		//엔터키 처리
		dto.setContent(dto.getContent().replaceAll("\n\r|\r\n|\r|\n","<br>"));
		return dao.wrtie(dto);
	}

	public int commentWrite(CommentDTO comment) {
		//comment.setMid("ddr");
		//댓글 내용[comment] + [(글 번호 + mid)-> 밑에 코드에 들어있다.] 가 모두 들어있다.
		comment.setMid((String)util.getSession().getAttribute("mid"));
		comment.setCip(util.getIp());
		
		//엔터키 처리
		comment.getComment().replaceAll("\n\r|\r\n|\r|\n","<br>");
		return dao.commentWrite(comment);
	}

	public List<CommentDTO> commentsList(int reNo) {
		return dao.commentsList(reNo);
	}

	public int postDel(int no) {
		WriteDTO dto = new WriteDTO();
		dto.setBoard_no(no); //no값 담기
		dto.setMid((String)util.getSession().getAttribute("mid")); // 글쓴 사람의 mid, session을 담았다.
		return dao.postDel(dto);
	}

	public int totalRecordCount() {
		return dao.totalRecordCount();
	}

	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setNo(cno);
		dto.setBoard_no(no);
		dto.setMid((String)util.getSession().getAttribute("mid"));
		return dao.deleteComment(dto);
	}

}
