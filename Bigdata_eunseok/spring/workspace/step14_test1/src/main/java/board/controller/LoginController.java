package board.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class LoginController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1.데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		// 2. 데이터 공유

		ModelAndView modelAndView = new ModelAndView();
		// 3. 화면 네비게이션
		if (name == null) { // 로그인 실패
			// response.sendRedirect("loginForm.jsp");
			modelAndView.setViewName("login.jsp");
		} else { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// 폴더 이름을 바꾸기 위해서 : member -> board
			modelAndView.setViewName("redirect:../board/boardList.do?pg=1");
		}
		return modelAndView;
	}
}
