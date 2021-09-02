package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 정보 추출
		// url : http://localhost:8080/step11/board/boardList.do?pg=1
		// uri : step11/board/boardList.do
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// path : /boardList.do
		System.out.println(path);
		
		// 2. 데이터 처리 코드 선택
		// => 클라이언트 요청 path에 따라 분기 (if-else 방식)
		String viewPage = null;
		HttpSession session = request.getSession();
		
		if(path.equals("/login.do")) {
			// 1.데이터 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			// DB
			MemberDAO dao = new MemberDAO();
			String name = dao.login(id, pwd);
			// 2. 데이터 공유
			
			// 3. 화면 네비게이션
			if(name == null) { 	// 로그인 실패
				//response.sendRedirect("loginForm.jsp");
				viewPage = "loginForm.jsp";
			} else {			// 로그인 성공
				session.setAttribute("memId", id);
				session.setAttribute("memName", name);
				// 폴더 이름을 바꾸기 위해서 : member -> board
				response.sendRedirect("../board/boardList.do?pg=1");
			}
		} else if(path.equals("/boardList.do")) {// 목록보기
			// 1. 데이터
			int pg = Integer.parseInt(request.getParameter("pg"));

			// DB
			BoardDAO dao = new BoardDAO();
			int totalA = dao.getTotalA(); // 총글수
			int totalP = (totalA + 4) / 5; // 총페이지수

			if (pg > totalP) pg = totalP;

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
			viewPage = "/board/boardList.jsp";
			
		} else if(path.equals("/boardWriteForm.do")) {
			viewPage = "../board/boardWriteForm.jsp";
		} else if(path.equals("/boardWrite.do")) {
			// 1.데이터 처리
			// 데이터			
			request.setCharacterEncoding("utf-8");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String name = (String)session.getAttribute("memName");
			String id = (String)session.getAttribute("memId");
			
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
			viewPage = "boardWrite.jsp";
		}
		
		// 3. view 처리 파일로 화면 이동
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}










