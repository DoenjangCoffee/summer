package org.monwo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int board_no, board_count, comment, mno;
	private String board_title, board_write, board_date, board_content, board_ip, board_del, mname, mid;
	// 게시판, 상세보기, 글 삭제, 
}
