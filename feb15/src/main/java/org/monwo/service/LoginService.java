package org.monwo.service;

import org.monwo.dao.LoginDAO;
import org.monwo.dto.LoginDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private Util util;
	
	public LoginDTO login(LoginDTO loginDTO) {
		
		return loginDAO.login(loginDTO);
	}

	public void mcountUp(LoginDTO loginDTO) {
		
		loginDAO.mcountUp(loginDTO); // 이녀석을 return 값이 없다.
	}

	public void mcountReset(LoginDTO loginDTO) {
		loginDAO.mcountReset(loginDTO);
	}
}
