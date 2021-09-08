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

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping("/main/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		int su = service.boardDelete(seq);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("/board/boardDelete.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/main/board.do")
	public ModelAndView board(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("con", "boardList");
		modelAndView.setViewName("/main/index.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		/* 페이징 */
		// => 한페이지당 목록 5개인 경우 : 총페이지수 = (총글수+4)/5
		// 총글수 : 12
		// 총페이지 수 : 3 (12+4)/5

		// 총글수 : 23
		// 총페이지 수 : 5 (23+4)/5

		// 총글수 : 25
		// 총페이지 수 : 5 (25+4)/5
		int totalA = service.getTotalA(); // 총글수
		int totalP = (totalA + 4) / 5; // 총페이지수

		if (pg > totalP)
			pg = totalP;

		// 3블럭으로 페이지 표시
		// 총페이지 수 : 8
		// [1][2][3][다음]
		// [이전][4][5][6][다음]
		// [이전][7][8]
		// startPage 계산 결과
		// pg=1 : (1-1)/3*3+1 => 1
		// pg=2 : (2-1)/3*3+1 => 1
		// pg=3 : (3-1)/3*3+1 => 1
		// pg=4 : (4-1)/3*3+1 => 4
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;

		/* DB */
		// 1페이지당 5개씩
		// pg=1 : rn>=1 and rn<=5
		// pg=2 : rn>=6 and rn<=10
		// pg=3 : rn>=11 and rn<=15

		int endNum = pg * 5;
		int startNum = endNum - 4;
		List<BoardDTO> list = service.boardList(startNum, endNum);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("con", "boardList");
		modelAndView.setViewName("/board/boardList.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// DTO에 저장
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSeq(seq);

		// DB
		int su = service.boardModify(dto);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("/board/boardModify.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request, HttpServletResponse response) {

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		BoardDTO dto = service.boardView(seq); // 1줄 데이터가 필요

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("/board/boardModifyForm.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardView.do")
	public ModelAndView boardView(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// 조회수 증가
		service.updateHit(seq);
		BoardDTO dto = service.boardView(seq);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("/board/boardView.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
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

		int su = service.boardWrite(dto);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("/board/boardWrite.jsp");

		return modelAndView;
	}

	@RequestMapping("/main/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board/boardWriteForm.jsp");
		
		return modelAndView;
	}
}
