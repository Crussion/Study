package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberBean;
import member.dao.MemberDAO;

public class ModifyAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String name = session.getAttribute("memName").toString();
		String id = session.getAttribute("memId").toString();
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		MemberDAO dao = new MemberDAO();
		MemberBean bean = new MemberBean();
		bean.setName(name);
		bean.setId(id);
		bean.setPwd(pwd);
		bean.setGender(gender);
		bean.setEmail1(email1);
		bean.setEmail2(email2);
		bean.setTel1(tel1);
		bean.setTel2(tel2);
		bean.setTel3(tel3);
		bean.setAddr(addr);
		
		int result = dao.member_modify(bean);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("</script>");
			return "index.jsp";
		}else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}
}
