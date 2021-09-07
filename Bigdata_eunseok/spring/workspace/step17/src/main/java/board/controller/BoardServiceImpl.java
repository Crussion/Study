package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		return boardDAO.boardList(startNum, endNum);
	}

	@Override
	public int getTotalA() {
		return boardDAO.getTotalA();
	}

	@Override
	public int boardWrite(BoardDTO dto) {
		return boardDAO.boardWrite(dto);
	}

	@Override
	public int updateHit(int seq) {
		return boardDAO.updateHit(seq);
	}

	@Override
	public BoardDTO boardView(int seq) {
		return boardDAO.boardView(seq);
	}

	@Override
	public int delete(int seq) {
		return boardDAO.delete(seq);
	}
	
}
