package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardWriteController{
	
	// HandlerMapping 클래스 설정 어노테이션
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1.데이터 처리
		// 데이터
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

		BoardDAO dao = new BoardDAO();
		int su = dao.boardWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
		/*
		// 2. 데이터 공유
		request.setAttribute("su", su);

		// 3. 화면 네비게이션
		return "boardWrite";
		*/
	}
}
