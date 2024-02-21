package org.monwo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class Util{
	public int str2Int(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	//2024-02-21 
	public HttpServletRequest req() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		//위 코드를 활용해 접속한 사용자의 세션을 가져올 수 있다.
		return request;
	}
	
	public HttpSession getSession() {
		//이미 위에 중복 되는 코드가 있기 때문에 req()를 호출해서 사용하면 중복되는 코드를 줄일 수 있다.
		HttpSession session = req().getSession();
		
		return session;
	}
	
	public String getIp() { // ip 불러오기
	    HttpServletRequest request = req();
			String ip = request.getHeader("X-FORWARDED-FOR");
				if(ip == null) {
					ip = request.getHeader("Proxy-Client-IP");
				}
				if(ip == null) {
					ip = request.getHeader("WL-Proxy-Client-IP");   
				}
				if(ip == null) {
					ip = request.getHeader("HTTP_CLIENT_IP");
				}
				if(ip == null) {
					ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				}
				if(ip == null) {
					ip = request.getRemoteAddr();
				}
			return ip;
	}
}
