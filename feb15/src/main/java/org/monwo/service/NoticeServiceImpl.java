package org.monwo.service;

import java.util.List;

import org.monwo.dto.NoticeDTO;
import org.springframework.stereotype.Service;
@Service("noticeService")
public class NoticeServiceImpl extends AbstractService implements NoticeService{

	@Override
	public List<NoticeDTO> noticeList() {

		return null;
	}

	@Override
	public NoticeDTO detail(int no) {

		return null;
	}

	@Override
	public int noticeWrite(NoticeDTO dto) {

		return 0;
	}

	@Override
	public int noticeDel(int no) {

		return 0;
	}

	@Override
	public int noticeUpdate(NoticeDTO dto) {

		return 0;
	}

}
