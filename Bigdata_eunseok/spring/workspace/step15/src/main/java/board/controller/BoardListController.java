package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardListController{

	// HandlerMapping 클래스 설정 어노테이션
	@RequestMapping(value="/board/boardList.do")
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

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
		
		/*
		// 2. 데이터 공유
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);

		// 3. 파일명 리턴
		return "boardList";//"/board/boardList.jsp";
		*/
	}
}
