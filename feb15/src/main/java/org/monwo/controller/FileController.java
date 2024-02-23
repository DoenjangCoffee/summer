package org.monwo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class FileController {
	@GetMapping("/file")
	public String file() {
		
		return "file";
	}
	@PostMapping("/file")
	public String file(@RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
		System.out.println("파일 이름 : "+upFile.getOriginalFilename());
		System.out.println("파일 크키 : "+upFile.getSize());
		System.out.println("파일 타입 : "+upFile.getContentType());
		
		// 경로 설정
		String root=request.getSession().getServletContext().getRealPath("/");
		System.out.println("upFileURL : "+root);
		String upfile = root + "resources\\upFile\\";
		System.out.println("upFile : "+upfile);
		
		//UUID 만들기
		UUID uuid = UUID.randomUUID();
		System.out.println("UUID ; "+uuid);
		String newFileName = uuid.toString() + "-"+upFile.getOriginalFilename();
		System.out.println("새로 만들어진 파일 이름 : "+newFileName);
		
		//진짜 올리기
		File f = new File(upfile, newFileName);
		try {
			
			// 썸네일 만들기
			FileOutputStream tn = new FileOutputStream(new File("c:\\temp\\upfile","s_"+newFileName));
			Thumbnailator.createThumbnail(upFile.getInputStream(),tn, 100, 100);
			tn.close();
			
			upFile.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/file";
	}
}
