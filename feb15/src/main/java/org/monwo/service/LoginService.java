package org.monwo.service;

import org.monwo.dao.LoginDAO;
import org.monwo.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService{
	@Autowired
	private LoginDAO loginDAO;
	
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
