package org.monwo.service;

import org.apache.commons.mail.EmailException;
import org.monwo.dao.RestDAO;
import org.monwo.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestService extends AbstractService{
	@Autowired
	private RestDAO dao;

	public int sendEmail() throws EmailException {
		if (util.getSession().getAttribute("mid")!=null) {// email, key, mid를 저장하는 것
			// 로그인 했기 때문에 발송을 할 수 있다.
			// 기능 : 메일 발송 + key 데이터베이스 저장
			String email = getEmail((String)util.getSession().getAttribute("mid"));
			String key = util.createKey();
			
			MemberDTO dto = new MemberDTO();
			dto.setMemail(email);
			dto.setMkey(key);
			dto.setMid((String)util.getSession().getAttribute("mid"));
			dao.setKey(dto);
			util.sendEmail(email, "스미싱 인증번호입니다.", key);
			return 1;
		} else {
			return 0;
		}
	}

	private String getEmail(String email) { // 사용자가 가입할 때 입력한 이메일 확인 하기 [전송하는 일]
		
		return dao.getEmail(email);
	}
	
}
