package board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class LoginController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1.데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		// 2. 데이터 공유

		// 3. 화면 네비게이션
		if (name == null) { // 로그인 실패
			// response.sendRedirect("loginForm.jsp");
			return "loginForm";
		} else { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// 폴더 이름을 바꾸기 위해서 : member -> board
			try {
				response.sendRedirect("../board/boardList.do?pg=1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
