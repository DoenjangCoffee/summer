package org.monwo.service;

import java.util.List;

import org.monwo.dto.GalleryDTO;

public interface GalleryService {

	public int galleryInsert(GalleryDTO dto);
	public List<GalleryDTO> galleryList();
	public GalleryDTO galleryDetail(int gno);
	public int alterGallery(int no);
}
