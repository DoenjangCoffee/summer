package org.monwo.service;

import java.util.List;

import org.monwo.dao.NoticeDAO;
import org.monwo.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl extends AbstractService implements NoticeService{

	@Autowired
	private NoticeDAO dao;
	
	@Override
	public List<NoticeDTO> noticeList() {
		
		return dao.noticeList();
	}
	
	@Override
	public NoticeDTO detail(int no) {

		return dao.detail(no);
	}

	@Override
	public int noticeWrite(NoticeDTO dto) {
		
		return dao.noticeWrite(dto);
	}

	@Override
	public int noticeDel(int no) {

		return dao.noticeDel(no);
	}

	@Override
	public int noticeUpdate(NoticeDTO dto) {

		return 0;
	}


}
