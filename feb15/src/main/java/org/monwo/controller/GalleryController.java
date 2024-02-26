package org.monwo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.monwo.dto.GalleryDTO;
import org.monwo.service.GalleryService;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {
	@Resource(name ="galleryService")
	private GalleryService gs;
	@Autowired
	private Util util;
	
	@GetMapping("/gallery")
	public String gallery(Model model) {
		List<GalleryDTO> list = gs.galleryList();
		model.addAttribute("list",list);
		return "gallery";
	}
	@GetMapping("/galleryInsert")
	public String galleryInsert() {
		
		return "galleryInsert";
	}

	@PostMapping("/galleryInsert")
	public String gallery(GalleryDTO dto, @RequestParam("file1") MultipartFile upFile) {
		System.out.println(dto.getGtitle());
		System.out.println(dto.getGcontent());
		System.out.println(upFile.getOriginalFilename());
		dto.setGtitle(dto.getGtitle());
		dto.setGcontent(dto.getGcontent());
		// 파일 업로드 => Util
		String newFileName = util.fileUpload(upFile);
		
		dto.setGfile(newFileName); // UUID도 추가하기
		
		int result = gs.galleryInsert(dto);
		
		return "redirect:/galleryInsert";
	}
	
	@GetMapping("/galleryDetail@{no}")
	public String galleryDetail(@PathVariable("no") String gno, Model model) { // 에러를 최소화 하기 위해 no를 String으로 받는다.
		int no = util.str2Int(gno);

		GalleryDTO detail =  gs.galleryDetail(no);
		model.addAttribute("detail", detail);
		return "galleryDetail";
	}
	
	@PostMapping("/alterGallery")
	public String alterGallery(@RequestParam("no") String gno) {
		int no = util.str2Int(gno);
		int result = gs.alterGallery(no);
		return "redirect:/gallery";
	}
	
	
	
	
}
