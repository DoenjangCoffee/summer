package org.monwo.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private int no, board_no, clike, mno;
	private String comment, mid, cdate, mname, cip;
	
}
