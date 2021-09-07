package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	public int boardWrite(BoardDTO dto);
	// 5개씩 목록보기
	public List<BoardDTO> boardList(int startNum, int endNum);
	// 상세보기
	public BoardDTO boardView(int seq);
	// 조회수 증가하기
	public int updateHit(int seq);
	// 총 데이터수 구하기
	public int getTotalA();
	// 게시글 삭제하기
	public int boardDelete(int seq );
	// 글수정
	public int boardModify(BoardDTO dto);
}
