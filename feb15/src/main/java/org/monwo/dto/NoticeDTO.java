package org.monwo.dto;

import lombok.Data;

@Data
public class NoticeDTO {
	private int nno, ndel, nread, nlike;
	private String ntitle, ncontent, ndate, nwritedate;
}
