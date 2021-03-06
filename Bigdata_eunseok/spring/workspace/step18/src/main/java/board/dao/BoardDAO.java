package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	// 목록 (5개씩)
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}
	// 총 데이터수
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.boardMapper.getTotalA");
	}
	// 글쓰기
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.boardMapper.boardWrite", dto);
	}	
	// 조회수 증가
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.boardMapper.updateHit", seq);
	}	
	// 상세보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}	
	// 삭제하기
	public int delete(int seq) {
		return sqlSession.delete("mybatis.boardMapper.delete", seq);
	}	
}
