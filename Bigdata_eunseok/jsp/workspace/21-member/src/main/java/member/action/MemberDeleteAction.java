package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class MemberDeleteAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String memId = session.getAttribute("memId").toString();
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberDelete(memId);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('탈퇴 성공');");
			out.println("</script>");
			
			session.removeAttribute("memName");
			session.removeAttribute("memId");
			
			// 무효화 : 모두 지우기
			session.invalidate();
		}else {
			out.println("<script>");
			out.println("alert('탈퇴 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return "logout.do";
	}
}
