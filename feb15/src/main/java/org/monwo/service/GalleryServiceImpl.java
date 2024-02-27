package org.monwo.service;

import java.util.List;

import org.monwo.dao.GalleryDAO;
import org.monwo.dto.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("galleryService") // controller에 설정한 이름으로 찾는다.
public class GalleryServiceImpl extends AbstractService implements GalleryService{
	
	@Autowired
	private GalleryDAO dao;
	

	@Override
	public List<GalleryDTO> galleryList() {
		return dao.galleryList();
	}

	@Override
	public GalleryDTO galleryDetail(int gno) {
		return dao.galleryDetail(gno);
	}

	@Override
	public int alterGallery(int no) {
		return dao.alterGallery(no);
	}

	@Override
	public int galleryInsert(GalleryDTO dto) {
			
			// 세션 추가
			if (util.getSession().getAttribute("mid") != null) {
				dto.setMid((String)util.getSession().getAttribute("mid"));
				return dao.galleryInsert(dto);
			} else {
				return 0;
			}
		}
	}

