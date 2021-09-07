package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int memberWrite(MemberDTO dto) {
		return sqlSession.insert("mybatis.Mapper.memberWrite", dto);
	}
	
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sqlSession.selectOne("mybatis.Mapper.login", map);
	}
	// 아이디 유무 검사
	public boolean isExistId(String id) {
		boolean exist = false;
		if(sqlSession.selectOne("mybatis.Mapper.isExistId", id) != null) {
			exist = true;
		}
		return exist;
	}
	// 회원정보 보기
	public MemberDTO memberView(String id) {
	      return sqlSession.selectOne("mybatis.Mapper.memberView", id);
	}
	// 회원정보 수정
	public int memberModify(MemberDTO dto) {
		return sqlSession.update("mybatis.Mapper.memberModify", dto);
	}
	// 총 회원수 구하기
	public int getTotalMember() {
		return sqlSession.selectOne("mybatis.Mapper.getTotalMember");
	}
	public List<MemberDTO> memberList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.Mapper.memberList", map);
	}
}