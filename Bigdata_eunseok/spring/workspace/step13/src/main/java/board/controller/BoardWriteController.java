package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		// 2. 데이터 공유
		request.setAttribute("su", su);

		// 3. 화면 네비게이션
		return "boardWrite";
	}
}
