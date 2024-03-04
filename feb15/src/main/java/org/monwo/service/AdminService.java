package org.monwo.service;

import java.util.List;

import org.monwo.dto.BoardDTO;
import org.monwo.dto.MemberDTO;
import org.monwo.dto.SearchDTO;

public interface AdminService {

	List<BoardDTO> boardList(SearchDTO searchDTO);

	int totalRecordCount(SearchDTO searchDTO);

	int postDel(int no);

	int checkGrade(MemberDTO memberDTO);

}
