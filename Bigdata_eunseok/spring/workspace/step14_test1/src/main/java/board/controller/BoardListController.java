package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardList.jsp");

		return modelAndView;
	}
}
