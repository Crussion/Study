package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;

@Controller
public class BoardDeleteController{
	
	// HandlerMapping 클래스 설정 어노테이션
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		BoardDAO dao = new BoardDAO();
		int su = dao.delete(seq);
		
		// ModelAndView : 공유데이터와 view 처리파일명 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardDelete.jsp");
		
		return modelAndView;
		
		/*
		request.setAttribute("pg", pg);
		request.setAttribute("su", su);
		
		return "boardDelete";
		*/
	}
}
