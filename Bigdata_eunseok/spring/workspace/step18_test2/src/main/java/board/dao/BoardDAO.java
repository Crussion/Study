package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	// 개별적으로 insert할 함수
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.Mapper.boardWrite", dto);
	}

	// 5개씩 목록보기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.Mapper.boardList", map);
	}

	// 상세보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.Mapper.boardView", seq);
	}

	// 조회수 증가하기
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.Mapper.updateHit", seq);
	}

	// 총 데이터수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.Mapper.getTotalA");
	}

	// 게시글 삭제하기
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.Mapper.boardDelete", seq);
	}

	// 글수정
	public int boardModify(BoardDTO dto) {
		return sqlSession.update("mybatis.Mapper.boardModify", dto);
	}
}
