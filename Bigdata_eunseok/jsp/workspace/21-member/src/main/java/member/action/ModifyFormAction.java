package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberBean;
import member.dao.MemberDAO;

public class ModifyFormAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = session.getAttribute("memId").toString();

		MemberDAO dao = new MemberDAO();
		MemberBean bean = dao.member_read(id);
		
		request.setAttribute("bean", bean);
		return "member/modifyForm.jsp";
	}
}
