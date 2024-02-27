package org.monwo.dao;

import java.util.List;

import org.monwo.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO extends AbstractDAO{

	public List<NoticeDTO> noticeList() {
		return sqlSession.selectList("notice.noticeList");
	}

	public int noticeWrite(NoticeDTO dto) {
		return sqlSession.insert("notice.noticeWrite", dto);
	}

	public NoticeDTO detail(int no) {
		return sqlSession.selectOne("notice.detail", no);
	}

	public int noticeDel(int no) {
		return sqlSession.update("notice.noticeDel", no);
	}
	
}
