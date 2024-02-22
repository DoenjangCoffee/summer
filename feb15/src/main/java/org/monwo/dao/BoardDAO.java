package org.monwo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.monwo.dto.BoardDTO;
import org.monwo.dto.CommentDTO;
import org.monwo.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlsession;
	public List<BoardDTO> boardList(int pageNo) {
		return sqlsession.selectList("board.boardList",pageNo);
	}
	public BoardDTO detail(int no) {
		return sqlsession.selectOne("board.detail",no);
	}
	public int wrtie(WriteDTO dto) {
		return sqlsession.insert("board.write",dto);
	}
	public void countUp(BoardDTO dto) {
		sqlsession.insert("board.countUp",dto);
	}
	public int commentWrite(CommentDTO comment) {
		return sqlsession.insert("board.commentWrite",comment);
	}
	public List<CommentDTO> commentsList(int reNo) {
		return sqlsession.selectList("board.commentsList",reNo);
	}
	public int postDel(WriteDTO dto) {
		return sqlsession.update("board.postDel", dto);
	}
	public int totalRecordCount() {
		return sqlsession.selectOne("board.totalRecordCount");
	}
	public int deleteComment(CommentDTO dto) {
		return sqlsession.update("board.deleteComment", dto);
	}
	public int checkCount(BoardDTO dto) {
		return sqlsession.selectOne("board.checkCount", dto);
	}
	public int likeUp(CommentDTO dto) {
		return sqlsession.update("board.likeUp",dto);
	}
	
}
