package org.monwo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.monwo.dto.BoardDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO extends AbstractDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return sqlSession.selectList("admin.boardList", searchDTO);
	}

	public int totalRecordCount(SearchDTO searchDTO) {
		return sqlSession.selectOne("admin.totalRecordCount",searchDTO);
	}

	public int postDel(int no) {
		return sqlSession.update("admin.postDel", no);
	}

	public int checkGrade(MemberDTO memberDTO) {
		return sqlSession.selectOne("admin.checkGrade", memberDTO);
	}
}
