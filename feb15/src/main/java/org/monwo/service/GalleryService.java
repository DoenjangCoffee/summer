package org.monwo.service;

import java.util.List;

import org.monwo.dao.GalleryDAO;
import org.monwo.dto.GalleryDTO;
import org.monwo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
	@Autowired
	private GalleryDAO dao;
	@Autowired
	private Util util;
	
	public int galleryInsert(GalleryDTO dto) {
		
		// 세션 추가
		if (util.getSession().getAttribute("mid") != null) {
			dto.setMid((String)util.getSession().getAttribute("mid"));
			return dao.galleryInsert(dto);
		} else {
			return 0;
		}
	}

	public List<GalleryDTO> galleryList() {
		return dao.galleryList();
	}
}
