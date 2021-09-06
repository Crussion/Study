package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardViewController{
	
	// HandlerMapping 클래스 설정 어노테이션
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		BoardDAO dao = new BoardDAO();
		
		// 조회수 증가
		dao.updateHit(seq);
		BoardDTO dto = dao.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
		
		/*
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("dto", dto);
		
		return "boardView";
		*/
	}
}
