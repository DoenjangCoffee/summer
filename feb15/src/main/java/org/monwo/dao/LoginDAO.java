package org.monwo.dao;

import org.monwo.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO extends AbstractDAO{
   
   public LoginDTO login(LoginDTO dto) {
      return sqlSession.selectOne("login.login", dto);
   }

   public void mcountUp(LoginDTO loginDTO) {
      sqlSession.update("login.mcountUp", loginDTO);
   }

   public void mcountReset(LoginDTO loginDTO) {
      sqlSession.update("login.mcountReset", loginDTO);
   }

   public int idCheck(String id) {
      return sqlSession.selectOne("login.idCheck",id);
      
   }

   public int nickCheck(String nick) {
      return sqlSession.selectOne("login.nickCheck", nick);
   }
}