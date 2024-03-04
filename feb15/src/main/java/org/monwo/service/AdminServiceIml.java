package org.monwo.service;

import java.util.List;

import org.monwo.dao.AdminDAO;
import org.monwo.dto.BoardDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceIml extends AbstractService implements AdminService {

	@Autowired
	private AdminDAO dao;
	
	@Override
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return dao.boardList(searchDTO);
	}

	@Override
	public int totalRecordCount(SearchDTO searchDTO) {
		return dao.totalRecordCount(searchDTO);

	}

	@Override
	public int postDel(int no) {
		return dao.postDel(no);
	}

	@Override
	public int checkGrade(MemberDTO memberDTO) {
		return dao.checkGrade(memberDTO);
	}

	
}
