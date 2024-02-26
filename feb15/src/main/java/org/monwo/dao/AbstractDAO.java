package org.monwo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

// 추상 클래스로 부모형태로 autowired를 하는 걸 다 몰아놓는다.
// 상속으로 뿌린다.
public class AbstractDAO {
	@Autowired
	protected SqlSession sqlSession;
}
