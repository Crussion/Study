package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// Command 객체 : @RequestMapping이 붙은 함수의 매개변수를 관리하는 객체
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, BoardDAO dao) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		int su = boardService.delete(seq);
		
		// ModelAndView : 공유데이터와 view 처리파일명 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardDelete.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		// DB
		int totalA = boardService.getTotalA(); // 총글수
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
		List<BoardDTO> list = boardService.boardList(startNum, endNum);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		
		// 조회수 증가
		boardService.updateHit(seq);
		BoardDTO dto = boardService.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {
		// 1.데이터 처리
		// 데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String name = (String) session.getAttribute("memName");
		String id = (String) session.getAttribute("memId");

		// DB
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setName(name);
		dto.setId(id);

		int su = boardService.boardWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
}
