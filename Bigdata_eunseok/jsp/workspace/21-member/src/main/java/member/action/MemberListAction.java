package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberBean;
import member.dao.MemberDAO;

public class MemberListAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		/*
		pg=1 : startNum = 1, endNum = 5
		pg=2 : startNum = 6, endNum = 10
		pg=n : startnum = endNum - 4, endNum = 5 * pg
		*/
		int endNum = pg * 5;
		int startNum = endNum - 4;
		MemberDAO dao = new MemberDAO();
		List<MemberBean> list = dao.memberList(startNum, endNum);
		
		//페이징 작업
		int total_content = dao.getTotalMember();
		int total_page = (total_content + 4) / 5;
		
		// 3페이지가 한블럭으로 표시
		//     1 2 3 다음
		// 이전 4 5 6 다음
		// 이전 7 8 
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if(endPage>total_page) endPage = total_page;
		
		request.setAttribute("list", list);
		request.setAttribute("total_page", total_page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pg", pg);
		
		return "member/memberList.jsp?pg=" + pg;
	}
}
