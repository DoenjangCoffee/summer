package org.monwo.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private int mno, mgrade, mcount;
	private String mid, mpw, mname, memail, mkey;
}
