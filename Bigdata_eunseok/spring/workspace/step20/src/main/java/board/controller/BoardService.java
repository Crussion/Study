package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	// 목록 (5개씩)
		public List<BoardDTO> boardList(int startNum, int endNum);
		// 총 데이터수
		public int getTotalA();
		// 글쓰기
		public int boardWrite(BoardDTO dto);
		// 조회수 증가
		public int updateHit(int seq);
		// 상세보기
		public BoardDTO boardView(int seq);
		// 삭제하기
		public int delete(int seq);
}
