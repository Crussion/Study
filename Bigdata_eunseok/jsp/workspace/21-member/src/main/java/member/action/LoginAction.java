package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import member.dao.MemberDAO;

public class LoginAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		
		PrintWriter out = response.getWriter();
		if(name != null){
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			return "index.jsp";
		}else{
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return null;
	}
}
