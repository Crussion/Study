package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		// DB
		BoardDAO dao = new BoardDAO();
		int totalA = dao.getTotalA(); // 총글수
		int totalP = (totalA + 4) / 5; // 총페이지수

		if (pg > totalP)
			pg = totalP;

		// 페이징 : 3블럭 페이지 표시
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;

		// 목록 : 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		List<BoardDTO> list = dao.boardList(startNum, endNum);

		// 2. 데이터 공유
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);

		// 3. 파일명 리턴
		return "boardList";//"/board/boardList.jsp";
	}
}
