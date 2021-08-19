package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		BoardBean bean = new BoardBean();
		bean.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		bean.setBoard_name(request.getParameter("board_name"));
		bean.setBoard_pwd(request.getParameter("board_pwd"));
		bean.setBoard_subject(request.getParameter("board_subject"));
		bean.setBoard_content(request.getParameter("board_content"));
		bean.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		bean.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		bean.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.insertReplyArticle(bean);
		
		if(result > 0) {
			return "boardList.do?pg=" + pg;
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글저장 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return null;
	}
}