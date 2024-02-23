package org.monwo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

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
	
	//숫자인지 검사하는 메소드
	public boolean intCheck(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void sendEmail(String email, String title, String key) throws EmailException {
				//mail 보내기
				String emailAddr = "";// 이메일 주소
				String name = "도지코인"; // 이름
				String passwd = ""; // 암호
				String hostName = "smtp-mail.outlook.com"; // 서버 
				int port = 587; // port number
				SimpleEmail se = new SimpleEmail();
				// 여기서 부터 진짜 메일을 보낸다.
				se.setCharset("UTF-8");
				se.setDebug(true);
				se.setHostName(hostName);				// 보내는 서버 설정 = 고정
				se.setAuthentication(emailAddr, passwd);// 보내느 사람 인증 = 고정
				se.setSmtpPort(port);					// 사용할 port = 고정
				se.setStartTLSEnabled(true);			// 보내는 사람 email, 보내는 사람
				se.setFrom(emailAddr, name);			// 받는 사람
				se.addTo(email);						// 사용자가 이메일 등록할 때 이 이메일로 등록했다.
				se.setSubject(title); 					// 제목
				se.setMsg("인증번호는 ["+key+"]"); 		//본문내용 text
				se.send(); // 전송하기
	}

	public String createKey() {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		String key =r.nextInt(9)+""+r.nextInt(9)+r.nextInt(9)+r.nextInt(9);
		return key;
	}

	public String fileUpload(MultipartFile upFile) { // 유효 ID 뽑기
		// 경로 저장하기
		String root = req().getSession().getServletContext().getRealPath("/"); // 실제 root 경로
		String upFilePath = root + "resources\\upFile\\";
		//UUID 뽑기
		UUID uuid = UUID.randomUUID(); //UUID 생성
		
		//UUID를 포함한 파일명
		String newFileName = uuid.toString() + upFile.getOriginalFilename();
		
		//실제 업로드
		File file = new File(upFilePath, newFileName);

		if (file.exists() == false) {
			file.mkdirs();// => 혹시 파일이 경로에 없다면 자동으로 만들어주는 코드.
		}
		
		try {
			
			FileOutputStream thumbnail = new FileOutputStream(new File(upFilePath, "s_"+newFileName));
			Thumbnailator.createThumbnail(upFile.getInputStream(),thumbnail, 200, 200);
			thumbnail.close();
			
			upFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFileName;
	}
}
