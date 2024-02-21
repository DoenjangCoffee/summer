package org.monwo.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private int count, mcount;
	private String id, pw, mname;
}
