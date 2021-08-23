package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		BoardDAO dao = new BoardDAO();
		BoardBean bean = dao.boardDetail(board_num);
		bean.setBoard_name(request.getParameter("board_name"));
		bean.setBoard_pwd(request.getParameter("board_pwd"));
		bean.setBoard_subject(request.getParameter("board_subject"));
		bean.setBoard_content(request.getParameter("board_content"));
		
		int result = dao.insertReplyArticle(bean);
		
		if(result > 0) {
			request.setAttribute("pg", pg);
			request.setAttribute("board_num", board_num);
			request.setAttribute("bean", bean);
			return "boardDetail.do";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 작성 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return null;
	}
}
